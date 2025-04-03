package it.gssi.astra.metaeditor.common.magnete;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.Binding;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import it.gssi.astra.metaeditor.common.LayoutScene;
import it.gssi.astra.metaeditor.common.dataManager.databinding.JFX2EMF;
import it.gssi.astra.metaeditor.common.dataManager.databinding.JFX2EMF.Contexts;
import it.gssi.astra.metaeditor.common.dataManager.databinding.JFX2EMF.Converters;
import it.gssi.astra.metaeditor.common.ente.Ente;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Bounds;
import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * The {@code AnchorPoint} class is a custom JavaFX component to be put inside the children of {@link Ente}
 * with specific X and Y coordinates in order to allow connections with other nodes in that exact position.
 * 
 * The compatible nodes are listed by the instance of MetaEditor configuration meta-model and currently hard coded in the custom editor by the EGL template.
 *
 */
public class AnchorPoint extends Circle {

	protected ObjectProperty<AnchorPoint> target = new SimpleObjectProperty<>(null);

	protected ObjectProperty<EObject> eObjectTarget = new SimpleObjectProperty<>(null);

	/**
	 * Creates a new AnchorPoint. This is always called by the FXML loader except for
	 * {@link AnchorPointVirtual#AnchorPointVirtual()} which is called by MetaEditor.
	 */
	public AnchorPoint() {
		super(2);
		this.setFill(Color.web("0xf6c016", 0.7));
		this.setMouseTransparent(true);
		setVisible(false);

		this.eObjectTargetProperty().addListener((observable, oldValue, newValue) -> {

			if (newValue == null) {

				// Disconnect anchor points if dropping old connections or if we are doing CTRL-Z of a connection
				this.autoDisconnect();

			} else {

				// Connect anchor points if we are doing CTRL-Z of a disconnection triggered by user or CTRL-Z of a delete
				if (this.getTarget() == null) {

					Ente source = this.getEntePadre();

					Ente nodoTarget = LayoutScene.getViewModelMap().get(newValue);

					if (nodoTarget != null) {
						AnchorPoint anchorPointTarget = nodoTarget.getAnchorPointByTarget(source);
						
						// Even if the previous call to getAnchorPointByTarget, which takes the source as parameter,
						// always returns the exact anchor point to use as target, there is an exception, that
						// happens when the Ente contains a mix of anchor points with an associated ref and
						// anchor points without an associated ref. In that case the method getAnhcorPointByTarget
						// return the anchor point without an associated ref.
						if (anchorPointTarget != null && !(this.getCompatibleTargets().contains(anchorPointTarget.getType()))) {
							return;
						}

						// The target anchor point should be null if it is virtual
						if (anchorPointTarget == null) {
							anchorPointTarget = MagneteUtils.getFullAnchorPointTarget(this, nodoTarget, 5);
						}

						if (anchorPointTarget == null) {
							// nodoTarget was not on canvas(e.g. Undo of delete of target node)
							return;
						}

						this.target.setValue(anchorPointTarget);
						anchorPointTarget.target.setValue(this);
					}

				}

			}

		});
	}

	private Binding binding = null;

	public String featureName;

	/**
	 * Executes the binding between the{@code eObjectTarget} of this anchor point and the value
	 * of the associated reference in the model.
	 * 
	 * @param featureName The name of the reference of the meta-class
	 */
	public void bindToReference(String featureName) {
		
		EObject model = (EObject) this.getEntePadre().getModel();
		
		binding = JFX2EMF.bindValues(Contexts.ANCHORPOINT_CONNECTIONS, model, featureName, this, "eObjectTarget", Converters.NONE);

		this.featureName = featureName;
		
	}
	
	/**
	 * Auxiliary method called by {@link LoadTask} that returns false
	 * if the binding has been established but the target is still null.
	 * 
	 */
	public boolean targetValid() {
		
		if (binding != null && this.getTarget() == null) 
			return false;
		else 
			return true;
	}


	private StringProperty type = new SimpleStringProperty();
	
	public StringProperty typeProperty() {
		return type;
	}

	public String getType() {
		return type.get();
	}

	public void setType(String type) {
		this.type.setValue(type);
	}

	public ObjectProperty<EObject> eObjectTargetProperty() {
		return eObjectTarget;
	}

	public EObject geteObjectTarget() {
		return eObjectTarget.get();
	}

	public void seteObjectTarget(EObject eObjectTarget) {
		this.eObjectTarget.setValue(eObjectTarget);
	}


	/**
	 * 
	 */
	private List<String> compatibleTargets = new ArrayList<String>();
	
	public List<String> getCompatibleTargets() {
		return compatibleTargets;
	}

	public void setCompatibleTargets(List<String> compatibleTarget) {
		this.compatibleTargets = compatibleTarget;
	}

	public ObjectProperty<AnchorPoint> targetProperty() {
		return target;
	}

	public AnchorPoint getTarget() {
		return target.get();
	}

	/**
	 * Sets the anchor point that represents the target.
	 * The reset case is managed by the listener of {@code eObjectTarget}.
	 * 
	 * @param target The target of the connection. It cannot be null by construction.
	 * @return true if the connection was successful, false otherwise
	 */
	public boolean setTarget(AnchorPoint target) {

		this.target.setValue(target);

		EObject value = (EObject) target.getEntePadre().getModel();
		this.seteObjectTarget(value);

		if (featureName != null) {// Check that the value has been correctly set in the model.

			EObject model = (EObject) this.getEntePadre().getModel();
			EStructuralFeature feature = model.eClass().getEStructuralFeature(featureName);

			if (model.eGet(feature) != value) {
				return false;
			}
		}

		return true;
	}


	private Ente entePadre;
	
	public Ente getEntePadre() {

		if (entePadre == null) {
			Parent parent = this.getParent();

			while (!(parent instanceof Ente)) {
				parent = parent.getParent();
			}

			entePadre = (Ente) parent;
		}

		return entePadre;
	}

	public void setEntePadre(Ente ente) {
		entePadre = ente;
	}


	private boolean virtual = false;
	
	public void setVirtual() {
		virtual = true;
		setFill(Color.TRANSPARENT);
		setStroke(Color.BLUE);
		setRadius(3);
		setStrokeWidth(0.5);
		getStrokeDashArray().addAll(0.5d, 1d);
		setStrokeDashOffset(0.5d);
		if (getEntePadre().anchorPointsVisibility)
			setVisible(true);
	}

	public boolean isVirtual() {
		return virtual;
	}

	/**
	 * Called by a {@link Ente#dropOldConnections(java.util.Set)}
	 * 
	 */
	public void disconnect() {
		if (getTarget() != null) {
			AnchorPoint target = getTarget();
			eObjectTarget.set(null);
			target.eObjectTarget.set(null);
		}
	}

	/**
	 * Called by the changes listener of {@link AnchorPoint#eObjectTarget}.
	 * 
	 * Resets the value of {@link AnchorPoint#target} when the value of
	 * {@link AnchorPoint#eObjectTarget} becomes null due to model notifications.
	 * 
	 */
	public void autoDisconnect() {
		
		// Checks if target != null to stop the cycle
		if (getTarget() != null) {
			
			AnchorPoint target = getTarget();

			this.target.setValue(null);
			
			target.autoDisconnect();
		}
	}

	/**
	 * Dispose the binding with the reference. It is called by {@link LayoutScene#deleteSelectedItems()}.
	 */
	public void dispose() {
		if (binding != null)
			this.binding.dispose();
	}

	
	/**
	 * <p>
	 * Called on the source anchor point that we are trying to connect.
	 * </p>
	 * 
	 * <p>
	 * Checks if this {@code AnchorPoint} is connected at least once,
	 * which doesn't mean it cannot accept other connections. Actually
	 * the support to multiple connections has not yet implemented, so
	 * if the target is different from null it can be connected again
	 * only if {@link AnchorPoint#disconnect()} is called first.
	 * </p>
	 * 
	 * <p>
	 * As a caveat to that, however, if the {@code AnchorPoint} doesn't
	 * have an associated reference in the graphical element and is connected
	 * to a child, then the method will return false to allow other connections
	 * and simulate the implementation of multiple connections. For this reason
	 * this case will maybe removed in the future.
	 * </p>
	 * 
	 * @return true if the anchor point has at least one target, false otherwise
	 */
	public boolean isConnectedAtLeastOnce() {

		if (getTarget() != null) {

			// Case the anchor point has no associated reference and it is connected to a child we return
			// false to allow other connections. This case will be removed in case of multilpe connections
			// future implementation.
			if (binding == null && 
					((EObject) geteObjectTarget()).eContainer() == this.entePadre.getModel()) {
				return false;
			}

			return true;
		}

		return false;
	}

	
	/**
	 * <p>
	 * Called on the target anchor point to which we want to connect.
	 * </p>
	 * 
	 * <p>
	 * Checks if the anchor point to which we are trying to connect
	 * has available connections. Taking into account that multiple
	 * connections has not been implemented yet, the code degenerates
	 * to the single case and only checks if the target equals null.
	 * 
	 * @return true if it has available connection, false otherwise.
	 */
	public boolean hasFreeConnections() {

		// If this anchorPoint does not have a reference associated to it by
		// configuration, then it can be magnetized multiple times.
		// This is a trick useful until multiple connections is not implemented.
		if (binding == null)
			return true;

		// Otherwise check if target is null, that means it is not connected.
		return getTarget() == null;
	}

	/**
	 * It returns the value of {@link Ente#identifier} in order to populate
	 * the associated reference field in the section 'AnchorPoints' of the
	 * properties view with a meaning string.
	 */
	public String toString() {
		return getEntePadre().identifier.getValue();
	}

	public double[] getCoordinatesRelativeToCanvas() {
		Bounds boundsInLocal;
		Bounds boundsInScene;

		boundsInLocal = this.getBoundsInLocal();
		boundsInScene = this.localToScene(boundsInLocal);

		Bounds sc = LayoutScene.getInstance().getCanvas().sceneToLocal(boundsInScene);

		return new double[] { sc.getCenterX(), sc.getCenterY() };
	}

}
