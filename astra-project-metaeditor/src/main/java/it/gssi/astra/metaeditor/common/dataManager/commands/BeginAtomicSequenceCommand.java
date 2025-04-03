package it.gssi.astra.metaeditor.common.dataManager.commands;

import java.util.Collection;

import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandStack;


/**
 * 
 * This class is used to delimit the begin operations in the {@link CommandStack}
 * 
 */
public class BeginAtomicSequenceCommand implements Command, AbstractCommand.NonDirtying {

	@Override
	public boolean canExecute() {
		return true;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean canUndo() {
		return true;
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<?> getResult() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<?> getAffectedObjects() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getLabel() {
		
		return "Begin";
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Command chain(Command command) {
		// TODO Auto-generated method stub
		return null;
	}

}
