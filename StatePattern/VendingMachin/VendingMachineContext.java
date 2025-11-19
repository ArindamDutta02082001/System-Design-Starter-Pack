package StatePattern.VendingMachin;

import java.lang.Thread.State;

import StatePattern.VendingMachin.inventory.Inventory;
import StatePattern.VendingMachin.inventory.Product;
import StatePattern.VendingMachin.states.DispenseInsertState;
import StatePattern.VendingMachin.states.InsertCoinState;
import StatePattern.VendingMachin.states.SelectState;
import StatePattern.VendingMachin.states.StateEnum;
import StatePattern.VendingMachin.states.StateFactory;
import StatePattern.VendingMachin.states.States;

public class VendingMachineContext {

    //This is the main class  or we can say the manager class

    public Product selectedProduct = null;
    public String pressedButton = "";

    public int balance =0;


    public InsertCoinState insertCoinState;
    public SelectState selectState;
    public DispenseInsertState dispenseInsertState;

    StateFactory stateFactory;

    // **vvi to store the current initial state in the State Pattern
    States currState;


    // setting the Inventory for putting the products ---> this you can do in the main class as this is a admin stuffs just to stimulate the VM
    public Inventory inventory;
    

    // constructor to initialize them
    VendingMachineContext()
    {

        inventory = new Inventory();

        stateFactory = new StateFactory(this);
        
        // // every time writing new new here is not acceptable in State Pattern , this part is moved to StateFactory class
        // insertCoinState = new InsertCoinState(this);
        // selectState = new SelectState(this);
        // dispenseInsertState = new DispenseInsertState(this);

        insertCoinState = (InsertCoinState) stateFactory.getState( StateEnum.INSERT_COIN_STATE );
        selectState = (SelectState) stateFactory.getState( StateEnum.ITEM_SELECTED_STATE );
        dispenseInsertState = (DispenseInsertState) stateFactory.getState( StateEnum.DISPENSE_ITEM_STATE);


        // setting the initial state  **vvi
        currState = insertCoinState;

    }


    // utility fn to put the products into inventory for admins
    public void addItemToInventory( String code , Product p)
    {
        inventory.addProduct( code , p);
    }





    // ** vvi    
    // for changing the current state
    public void setCurrState( States state)
    {
        this.currState = state;
    }




    // utiltiy fns for the consumer of the VM

    public void insertCoin( int amt)    // for inserting the coin
    {
        currState.insertCoin( this , amt);
    }

    public void pressButtonToSelectItem( String code)
    {
        this.pressedButton = code;
        currState.pressButton( this , code);
    }

    public void selectProduct( Product product)
    {
        this.selectedProduct = product;
    }

    public void dispenseItem()
    {
        currState.dispenseItem( this);
    }



    // utility fucntion to reset the context so that I can add multiple test cases in the main class
    // else bar bar new VendingMachineContext() krna padega not a good practice
    public void resetVendingMachineContext()
    {
        this.currState = insertCoinState;
    }


    
}
