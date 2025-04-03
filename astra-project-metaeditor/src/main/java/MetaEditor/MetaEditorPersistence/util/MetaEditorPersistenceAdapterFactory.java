/**
 */
package MetaEditor.MetaEditorPersistence.util;

import MetaEditor.MetaEditorPersistence.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see MetaEditor.MetaEditorPersistence.MetaEditorPersistencePackage
 * @generated
 */
public class MetaEditorPersistenceAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static MetaEditorPersistencePackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetaEditorPersistenceAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = MetaEditorPersistencePackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MetaEditorPersistenceSwitch<Adapter> modelSwitch =
		new MetaEditorPersistenceSwitch<Adapter>() {
			@Override
			public Adapter caseMetaEditorPersistence(MetaEditorPersistence object) {
				return createMetaEditorPersistenceAdapter();
			}
			@Override
			public Adapter caseElementPosition(ElementPosition object) {
				return createElementPositionAdapter();
			}
			@Override
			public Adapter caseBendableElementPosition(BendableElementPosition object) {
				return createBendableElementPositionAdapter();
			}
			@Override
			public Adapter caseRotationPosition(RotationPosition object) {
				return createRotationPositionAdapter();
			}
			@Override
			public Adapter caseBendPoint(BendPoint object) {
				return createBendPointAdapter();
			}
			@Override
			public Adapter casePosition(Position object) {
				return createPositionAdapter();
			}
			@Override
			public Adapter caseCanvasSection(CanvasSection object) {
				return createCanvasSectionAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link MetaEditor.MetaEditorPersistence.MetaEditorPersistence <em>Meta Editor Persistence</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see MetaEditor.MetaEditorPersistence.MetaEditorPersistence
	 * @generated
	 */
	public Adapter createMetaEditorPersistenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link MetaEditor.MetaEditorPersistence.ElementPosition <em>Element Position</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see MetaEditor.MetaEditorPersistence.ElementPosition
	 * @generated
	 */
	public Adapter createElementPositionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link MetaEditor.MetaEditorPersistence.BendableElementPosition <em>Bendable Element Position</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see MetaEditor.MetaEditorPersistence.BendableElementPosition
	 * @generated
	 */
	public Adapter createBendableElementPositionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link MetaEditor.MetaEditorPersistence.RotationPosition <em>Rotation Position</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see MetaEditor.MetaEditorPersistence.RotationPosition
	 * @generated
	 */
	public Adapter createRotationPositionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link MetaEditor.MetaEditorPersistence.BendPoint <em>Bend Point</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see MetaEditor.MetaEditorPersistence.BendPoint
	 * @generated
	 */
	public Adapter createBendPointAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link MetaEditor.MetaEditorPersistence.Position <em>Position</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see MetaEditor.MetaEditorPersistence.Position
	 * @generated
	 */
	public Adapter createPositionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link MetaEditor.MetaEditorPersistence.CanvasSection <em>Canvas Section</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see MetaEditor.MetaEditorPersistence.CanvasSection
	 * @generated
	 */
	public Adapter createCanvasSectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //MetaEditorPersistenceAdapterFactory
