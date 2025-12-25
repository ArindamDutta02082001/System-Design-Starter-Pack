package StatePattern.VendingMachin;

import StatePattern.VendingMachin.entity.Product;
import StatePattern.VendingMachin.states.DispenseInsertState;
import StatePattern.VendingMachin.states.InsertCoinState;
import StatePattern.VendingMachin.states.SelectState;
import StatePattern.VendingMachin.states.StateEnum;
import StatePattern.VendingMachin.states.StateFactory;
import StatePattern.VendingMachin.states.States;

import java.util.HashMap;
import java.util.Map;

public class VendingMachine {

    // mapping of the product code to the product object
    Map<String, Product> productMap = new HashMap<>();


    //utility functions
    public void addProduct( String code , Product p)
    {
        if(!productMap.containsKey(code))   // new product
            productMap.put( code , p);
    }

    // to update the qty of the product
    public void updateProductQty( String code , Integer qty)
    {
        if(productMap.containsKey(code))   // product exists
            productMap.get(code).quantity = qty;
        else
            System.out.println(" Product does not exist !! ");
    }

    // to get an item based on the button code
    public Product getProduct( String code )
    {
        return productMap.getOrDefault(code, null);
    }







    //This is the main class, or we can say the manager class

    public Product selectedProduct = null;
    public String pressedButton ="";
    public int balance =0;


    public InsertCoinState insertCoinState;
    public SelectState selectState;
    public DispenseInsertState dispenseInsertState;

    StateFactory stateFactory;

    // **vvi to store the current initial state in the State Pattern
    States currState;
    

    // constructor to initialize them
    VendingMachine()
    {

        stateFactory = new StateFactory(this);
        
        // // every time writing new here is not acceptable in State Pattern , this part is moved to StateFactory class
        // insertCoinState = new InsertCoinState(this);
        // selectState = new SelectState(this);
        // dispenseInsertState = new DispenseInsertState(this);

        insertCoinState = (InsertCoinState) stateFactory.getState( StateEnum.INSERT_COIN_STATE );
        selectState = (SelectState) stateFactory.getState( StateEnum.ITEM_SELECTED_STATE );
        dispenseInsertState = (DispenseInsertState) stateFactory.getState( StateEnum.DISPENSE_ITEM_STATE);


        // setting the initial state  **vvi
        currState = insertCoinState;

    }



    // ** vvi    
    // for changing the current state
    public void setCurrState( States state)
    {
        this.currState = state;
    }




    // utiltiy fns to trigger the state methods

    public void insertCoin( int amt)    // for inserting the coin
    {
        currState.insertCoin(  amt);
    }

    public void pressButtonToSelectItem( String code)
    {
        currState.pressButton(  code);
    }

    public void selectProduct( Product product)
    {
        this.selectedProduct = product;
    }

    public void dispenseItem()
    {
        currState.dispenseItem();
    }



    // utility function to reset the context so that I can add multiple test cases in the main class
    // else bar bar new VendingMachine() krna padega not a good practice
    public void resetVendingMachineContext()
    {
        this.currState = insertCoinState;
    }


    
}
