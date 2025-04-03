/**
 */
package MetaEditor.MetaEditorPersistence.impl;

import MetaEditor.MetaEditorPersistence.CanvasSection;
import MetaEditor.MetaEditorPersistence.ElementPosition;
import MetaEditor.MetaEditorPersistence.MetaEditorPersistence;
import MetaEditor.MetaEditorPersistence.MetaEditorPersistencePackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Meta Editor Persistence</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link MetaEditor.MetaEditorPersistence.impl.MetaEditorPersistenceImpl#getElementPositions <em>Element Positions</em>}</li>
 *   <li>{@link MetaEditor.MetaEditorPersistence.impl.MetaEditorPersistenceImpl#getCanvasWidth <em>Canvas Width</em>}</li>
 *   <li>{@link MetaEditor.MetaEditorPersistence.impl.MetaEditorPersistenceImpl#getCanvasHeight <em>Canvas Height</em>}</li>
 *   <li>{@link MetaEditor.MetaEditorPersistence.impl.MetaEditorPersistenceImpl#getCanvasSections <em>Canvas Sections</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MetaEditorPersistenceImpl extends MinimalEObjectImpl.Container implements MetaEditorPersistence {
	/**
	 * The cached value of the '{@link #getElementPositions() <em>Element Positions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElementPositions()
	 * @generated
	 * @ordered
	 */
	protected EList<ElementPosition> elementPositions;

	/**
	 * The default value of the '{@link #getCanvasWidth() <em>Canvas Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCanvasWidth()
	 * @generated
	 * @ordered
	 */
	protected static final int CANVAS_WIDTH_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getCanvasWidth() <em>Canvas Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCanvasWidth()
	 * @generated
	 * @ordered
	 */
	protected int canvasWidth = CANVAS_WIDTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getCanvasHeight() <em>Canvas Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCanvasHeight()
	 * @generated
	 * @ordered
	 */
	protected static final int CANVAS_HEIGHT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getCanvasHeight() <em>Canvas Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCanvasHeight()
	 * @generated
	 * @ordered
	 */
	protected int canvasHeight = CANVAS_HEIGHT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getCanvasSections() <em>Canvas Sections</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCanvasSections()
	 * @generated
	 * @ordered
	 */
	protected EList<CanvasSection> canvasSections;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MetaEditorPersistenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetaEditorPersistencePackage.Literals.META_EDITOR_PERSISTENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ElementPosition> getElementPositions() {
		if (elementPositions == null) {
			elementPositions = new EObjectContainmentEList<ElementPosition>(ElementPosition.class, this, MetaEditorPersistencePackage.META_EDITOR_PERSISTENCE__ELEMENT_POSITIONS);
		}
		return elementPositions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getCanvasWidth() {
		return canvasWidth;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCanvasWidth(int newCanvasWidth) {
		int oldCanvasWidth = canvasWidth;
		canvasWidth = newCanvasWidth;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetaEditorPersistencePackage.META_EDITOR_PERSISTENCE__CANVAS_WIDTH, oldCanvasWidth, canvasWidth));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getCanvasHeight() {
		return canvasHeight;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCanvasHeight(int newCanvasHeight) {
		int oldCanvasHeight = canvasHeight;
		canvasHeight = newCanvasHeight;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetaEditorPersistencePackage.META_EDITOR_PERSISTENCE__CANVAS_HEIGHT, oldCanvasHeight, canvasHeight));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<CanvasSection> getCanvasSections() {
		if (canvasSections == null) {
			canvasSections = new EObjectContainmentEList<CanvasSection>(CanvasSection.class, this, MetaEditorPersistencePackage.META_EDITOR_PERSISTENCE__CANVAS_SECTIONS);
		}
		return canvasSections;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MetaEditorPersistencePackage.META_EDITOR_PERSISTENCE__ELEMENT_POSITIONS:
				return ((InternalEList<?>)getElementPositions()).basicRemove(otherEnd, msgs);
			case MetaEditorPersistencePackage.META_EDITOR_PERSISTENCE__CANVAS_SECTIONS:
				return ((InternalEList<?>)getCanvasSections()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MetaEditorPersistencePackage.META_EDITOR_PERSISTENCE__ELEMENT_POSITIONS:
				return getElementPositions();
			case MetaEditorPersistencePackage.META_EDITOR_PERSISTENCE__CANVAS_WIDTH:
				return getCanvasWidth();
			case MetaEditorPersistencePackage.META_EDITOR_PERSISTENCE__CANVAS_HEIGHT:
				return getCanvasHeight();
			case MetaEditorPersistencePackage.META_EDITOR_PERSISTENCE__CANVAS_SECTIONS:
				return getCanvasSections();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MetaEditorPersistencePackage.META_EDITOR_PERSISTENCE__ELEMENT_POSITIONS:
				getElementPositions().clear();
				getElementPositions().addAll((Collection<? extends ElementPosition>)newValue);
				return;
			case MetaEditorPersistencePackage.META_EDITOR_PERSISTENCE__CANVAS_WIDTH:
				setCanvasWidth((Integer)newValue);
				return;
			case MetaEditorPersistencePackage.META_EDITOR_PERSISTENCE__CANVAS_HEIGHT:
				setCanvasHeight((Integer)newValue);
				return;
			case MetaEditorPersistencePackage.META_EDITOR_PERSISTENCE__CANVAS_SECTIONS:
				getCanvasSections().clear();
				getCanvasSections().addAll((Collection<? extends CanvasSection>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case MetaEditorPersistencePackage.META_EDITOR_PERSISTENCE__ELEMENT_POSITIONS:
				getElementPositions().clear();
				return;
			case MetaEditorPersistencePackage.META_EDITOR_PERSISTENCE__CANVAS_WIDTH:
				setCanvasWidth(CANVAS_WIDTH_EDEFAULT);
				return;
			case MetaEditorPersistencePackage.META_EDITOR_PERSISTENCE__CANVAS_HEIGHT:
				setCanvasHeight(CANVAS_HEIGHT_EDEFAULT);
				return;
			case MetaEditorPersistencePackage.META_EDITOR_PERSISTENCE__CANVAS_SECTIONS:
				getCanvasSections().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MetaEditorPersistencePackage.META_EDITOR_PERSISTENCE__ELEMENT_POSITIONS:
				return elementPositions != null && !elementPositions.isEmpty();
			case MetaEditorPersistencePackage.META_EDITOR_PERSISTENCE__CANVAS_WIDTH:
				return canvasWidth != CANVAS_WIDTH_EDEFAULT;
			case MetaEditorPersistencePackage.META_EDITOR_PERSISTENCE__CANVAS_HEIGHT:
				return canvasHeight != CANVAS_HEIGHT_EDEFAULT;
			case MetaEditorPersistencePackage.META_EDITOR_PERSISTENCE__CANVAS_SECTIONS:
				return canvasSections != null && !canvasSections.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (canvasWidth: ");
		result.append(canvasWidth);
		result.append(", canvasHeight: ");
		result.append(canvasHeight);
		result.append(')');
		return result.toString();
	}

} //MetaEditorPersistenceImpl
