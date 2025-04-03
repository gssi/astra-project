package it.gssi.astra.metaeditor.common.dataManager.commands;

import java.util.Iterator;

import org.eclipse.emf.common.command.AbortExecutionException;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.Command;

import it.gssi.astra.metaeditor.common.LayoutScene;

public class CustomCommandStack extends BasicCommandStack {
	
	private boolean readOnly = false;

	/**
	 * @return true if the stack is currently being read by another task (e.g. undo)
	 */
	public boolean isReadOnly() {
		return readOnly;
	}

	/**
	 * Called by another task which wants to lock write access to the stack
	 * 
	 * @param readOnly
	 */
	public void setReadOnly(boolean readOnly) {
		this.readOnly = readOnly;
	}

	@Override
	public void execute(Command command) {
		// If the command is executable, record and execute it.
		//
		if (command != null) {
			if (command.canExecute()) {
				try {
					command.execute();

					// Check per non far apparire l'asterisco in caso di sovrascrittture con lo stesso valore
					if (LayoutScene.getInstance().getResource().isModified()
							|| LayoutScene.getInstance().getResourcePersistance().isModified()
							|| command instanceof BeginAtomicSequenceCommand
							|| command instanceof EndAtomicSequenceCommand) {

						// Clear the list past the top.
						//
						for (Iterator<Command> commands = commandList.listIterator(top + 1); commands
								.hasNext(); commands.remove()) {
							Command otherCommand = commands.next();
							otherCommand.dispose();
						}

						// Record the successfully executed command.
						//
						mostRecentCommand = command;
						commandList.add(command);
						++top;

						// This is kind of tricky.
						// If the saveIndex was in the redo part of the command list which has now been
						// wiped out,
						// then we can never reach a point where a save is not necessary, not even if we
						// undo all the way back to the beginning.
						//
						if (saveIndex >= top) {
							// This forces isSaveNeded to always be true.
							//
							saveIndex = -2;
						}
						notifyListeners();
					}

				} catch (AbortExecutionException exception) {
					command.dispose();
				} catch (RuntimeException exception) {
					handleError(exception);
					mostRecentCommand = null;
					command.dispose();
					notifyListeners();
				}
			} else {
				command.dispose();
			}
		}
	}

}
