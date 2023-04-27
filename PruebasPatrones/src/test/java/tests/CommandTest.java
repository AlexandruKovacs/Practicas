package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import calculator.Calculator;
import calculator.Command;
import calculator.CommandManager;
import calculator.Invoker;

public class CommandTest {

    private Calculator calculator;
    private CommandManager commandManager;

    @Before
    public void setUp() {
        calculator = new Calculator(10);
        commandManager = new CommandManager(calculator);
    }

    @Test
    public void testSumar() {
    	Command sumarCommand = Invoker.getCommand(new String[] {"7", "sumar"}, calculator);
        commandManager.registCommand(sumarCommand);
        assertEquals(17, calculator.getValor());
    }

    @Test
    public void testRestar() {
    	Command restarCommand = Invoker.getCommand(new String[] {"3", "restar"}, calculator);
        commandManager.registCommand(restarCommand);
        assertEquals(7, calculator.getValor());
    }

    @Test
    public void testMultiplicar() {
    	Command multiplicarCommand = Invoker.getCommand(new String[] {"2", "multiplicar"}, calculator);
        commandManager.registCommand(multiplicarCommand);
        assertEquals(20, calculator.getValor());
    }

    @Test
    public void testDividir() {
    	Command dividirCommand = Invoker.getCommand(new String[] {"5", "dividir"}, calculator);
        commandManager.registCommand(dividirCommand);
        assertEquals(2, calculator.getValor());
    }

    @Test
    public void testSet() {
    	Command setCommand = Invoker.getCommand(new String[] {"7", "set"}, calculator);
        commandManager.registCommand(setCommand);
        assertEquals(7, calculator.getValor());
    }
    
    @Test
    public void testUndo() {
    	Command sumarCommand = Invoker.getCommand(new String[] {"5", "sumar"}, calculator);
        commandManager.registCommand(sumarCommand);
        assertEquals(15, calculator.getValor());
        
        commandManager.undoCommand(sumarCommand);
        assertEquals(10, calculator.getValor());
    }
    
    @Test
    public void testUndoSet() {
    	Command setCommandUndo = Invoker.getCommand(new String[] {"25", "set"}, calculator);
    	commandManager.registCommand(setCommandUndo);
    	assertEquals(25, calculator.getValor());
    	
    	commandManager.undoCommand(setCommandUndo);
    	assertEquals(10, calculator.getValor());
    }
    
}

