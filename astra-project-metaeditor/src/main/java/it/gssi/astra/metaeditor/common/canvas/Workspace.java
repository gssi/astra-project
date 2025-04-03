package it.gssi.astra.metaeditor.common.canvas;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;

import MetaEditor.MetaEditorPersistence.MetaEditorPersistence;
import it.gssi.astra.metaeditor.common.LayoutScene;
import it.gssi.astra.metaeditor.common.utility.EditorProperties;
import it.gssi.astra.metaeditor.common.utility.FXMLUtil;
import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.Event;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * This class is a UI component that extends {@link TabPane} and represents a
 * set of tabs within the editor. Each tab is formed by a {@link WorkspaceTab}
 */
public class Workspace extends TabPane {

	private static String BASE_PATH_FXML = EditorProperties.get("base.path");
	private static String FILE_NAME_FXML = EditorProperties.get("workspace.fxml");

	private Tab oldTab;

	public ContainerCanvas getContainerCanvas() {
		Tab selectedTab = this.getSelectionModel().getSelectedItem();
		if (selectedTab != null) {
			return (ContainerCanvas) selectedTab.getContent();
		} else {
			return null;
		}
	}

	public Tab getSelectedTab() {
		return this.getSelectionModel().getSelectedItem();
	}

	public Tab getOldTab() {
		return this.oldTab;
	}

	public Workspace() {

		FXMLUtil.loadFXML(this, BASE_PATH_FXML + FILE_NAME_FXML);

		this.getSelectionModel().selectedItemProperty().addListener((ov, oldTab, newTab) -> {

			SelectionModel.clear(true);

			if (newTab != null) {
				// There is at least one tab open
				LayoutScene.getInstance().treeView.setRoot(((ContainerCanvas) newTab.getContent()).treeRoot);
				LayoutScene.getInstance().showRootProperties();
			}

			if (oldTab != null) {
				// Bring clipboard to the new tab
				Collection<Object> oldClipboard = ((ContainerCanvas) oldTab.getContent()).getEditingDomain()
						.getClipboard();
				if (oldClipboard != null && getContainerCanvas() != null) {
					getContainerCanvas().getEditingDomain().setClipboard(oldClipboard);
				}
				this.oldTab = oldTab;
			}
		});
	}

	public List<ContainerCanvas> getAllContainerCanvas() {

		var list = new ArrayList<ContainerCanvas>();

		this.getTabs().forEach(tab -> {
			list.add((ContainerCanvas) tab.getContent());
		});

		return list;
	}

	public void selectTab(int indexTab) {
		SingleSelectionModel<Tab> selectionModel = this.getSelectionModel();
		selectionModel.select(indexTab);// select by index starting with 0
	}

	private void addCanvas(String title, Resource resource, Resource resourcePersistence,
			MetaEditorPersistence rootPersistence, AdapterFactoryEditingDomain editingDomain) {

		WorkspaceTab nuovoTab = new WorkspaceTab(this, title, resource, resourcePersistence, rootPersistence,
				editingDomain);
		this.getTabs().add(nuovoTab);

		Platform.runLater(() -> {
			this.getSelectionModel().select(nuovoTab);
		});
	}

	public void enableAsterisk() {
		Image m = new Image(LayoutScene.class.getResource("/common/img/asterisco.png").toExternalForm());
		this.getSelectionModel().getSelectedItem().setGraphic(new ImageView(m));
	}

	public void disableAsterisk() {
		this.getSelectionModel().getSelectedItem().setGraphic(null);
	}

	public void createCanvas(String title, Resource resource, Resource resourcePersistence,
			MetaEditorPersistence rootPersistence, AdapterFactoryEditingDomain editingDomain) {
		addCanvas(title, resource, resourcePersistence, rootPersistence, editingDomain);
		Platform.runLater(() -> {
			getContainerCanvas().createDefault();
		});
	}

	public void loadCanvas(String title, Resource resource, Resource resourcePersistence,
			MetaEditorPersistence rootPersistence, AdapterFactoryEditingDomain editingDomain) {

		addCanvas(title, resource, resourcePersistence, rootPersistence, editingDomain);

		Platform.runLater(() -> {
			getContainerCanvas().load();
		});

	}

	/**
	 * Closes all workspace tabs. Runs the method {@link #closeTabAndWait()
	 * closeTabAndWait} first on {@code firstTabToClose} and subsequently on the
	 * other tabs.
	 * 
	 * @see closeRequestTabSingleThread()
	 * @param firstTabToClose
	 */
	public void closeAllTabs(WorkspaceTab firstTabToClose) {

		ExecutorService exec = Executors.newSingleThreadExecutor();

		exec.submit(() -> {

			Boolean answer = closeRequestTabSingleThread((WorkspaceTab) firstTabToClose);

			if (answer != null) {
				closeOtherTabs(firstTabToClose);
			}
		});

		exec.shutdown();
	}

	/**
	 * Closes all workspace tabs except @param firstTabToClose.
	 * 
	 * @see closeRequestTabSingleThread()
	 * @param tab
	 */
	public void closeOtherTabs(WorkspaceTab tab) {

		ExecutorService exec = Executors.newSingleThreadExecutor();

		for (Tab otherTab : this.getTabs()) {

			if (otherTab instanceof WorkspaceTab) {
				if (otherTab != tab) {

					exec.submit(() -> {

						Boolean answer = closeRequestTabSingleThread((WorkspaceTab) otherTab);

						if (answer == null) {
							exec.shutdownNow();
						}
					});

				}
			}
		}

		exec.shutdown();
	}

	/**
	 * Closes the workspace tab
	 * 
	 * @see closeRequestTabSingleThread()
	 * @param tab
	 */
	public void closeRequestTab(WorkspaceTab tab) {

		ExecutorService exec = Executors.newSingleThreadExecutor();

		exec.submit(() -> {
			closeRequestTabSingleThread(tab);
		});

		exec.shutdown();
	}

	/**
	 * Closes the {@code tab} by launching the
	 * {@code TAB_CLOSE_REQUEST_EVENT} and waiting until the event is consumed. This
	 * method must be used within a {@link java.lang.Runnable}
	 * 
	 * @param tab
	 */
	private Boolean closeRequestTabSingleThread(WorkspaceTab tab) {

		final ObjectProperty<Boolean> resProperty = new SimpleObjectProperty<>(null);

		try {

			final CountDownLatch latch = new CountDownLatch(1);

			Platform.runLater(() -> {

				this.getSelectionModel().select(tab);

				Boolean answer = tab.closeRequest(new Event(tab, tab, Tab.TAB_CLOSE_REQUEST_EVENT));

				resProperty.set(answer);

				if (answer != null) {
					this.getTabs().remove(tab);
					tab.closed(new Event(tab, tab, Tab.CLOSED_EVENT));
				}

				latch.countDown();
			});

			latch.await();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return resProperty.get();
	}
}
