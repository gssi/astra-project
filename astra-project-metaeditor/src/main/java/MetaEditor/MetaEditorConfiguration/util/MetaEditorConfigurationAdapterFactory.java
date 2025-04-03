/**
 */
package MetaEditor.MetaEditorConfiguration.util;

import MetaEditor.MetaEditorConfiguration.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see MetaEditor.MetaEditorConfiguration.MetaEditorConfigurationPackage
 * @generated
 */
public class MetaEditorConfigurationAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static MetaEditorConfigurationPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetaEditorConfigurationAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = MetaEditorConfigurationPackage.eINSTANCE;
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
	protected MetaEditorConfigurationSwitch<Adapter> modelSwitch =
		new MetaEditorConfigurationSwitch<Adapter>() {
			@Override
			public Adapter caseNamedElement(NamedElement object) {
				return createNamedElementAdapter();
			}
			@Override
			public Adapter caseUneditableFeaturesElement(UneditableFeaturesElement object) {
				return createUneditableFeaturesElementAdapter();
			}
			@Override
			public Adapter caseMetaEditorConfiguration(MetaEditorConfiguration object) {
				return createMetaEditorConfigurationAdapter();
			}
			@Override
			public Adapter caseGraphicalElement(GraphicalElement object) {
				return createGraphicalElementAdapter();
			}
			@Override
			public Adapter caseAnchorPoint(AnchorPoint object) {
				return createAnchorPointAdapter();
			}
			@Override
			public Adapter caseConfigurationOptions(ConfigurationOptions object) {
				return createConfigurationOptionsAdapter();
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
	 * Creates a new adapter for an object of class '{@link MetaEditor.MetaEditorConfiguration.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see MetaEditor.MetaEditorConfiguration.NamedElement
	 * @generated
	 */
	public Adapter createNamedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link MetaEditor.MetaEditorConfiguration.UneditableFeaturesElement <em>Uneditable Features Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see MetaEditor.MetaEditorConfiguration.UneditableFeaturesElement
	 * @generated
	 */
	public Adapter createUneditableFeaturesElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link MetaEditor.MetaEditorConfiguration.MetaEditorConfiguration <em>Meta Editor Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see MetaEditor.MetaEditorConfiguration.MetaEditorConfiguration
	 * @generated
	 */
	public Adapter createMetaEditorConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link MetaEditor.MetaEditorConfiguration.GraphicalElement <em>Graphical Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see MetaEditor.MetaEditorConfiguration.GraphicalElement
	 * @generated
	 */
	public Adapter createGraphicalElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link MetaEditor.MetaEditorConfiguration.AnchorPoint <em>Anchor Point</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see MetaEditor.MetaEditorConfiguration.AnchorPoint
	 * @generated
	 */
	public Adapter createAnchorPointAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link MetaEditor.MetaEditorConfiguration.ConfigurationOptions <em>Configuration Options</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see MetaEditor.MetaEditorConfiguration.ConfigurationOptions
	 * @generated
	 */
	public Adapter createConfigurationOptionsAdapter() {
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

} //MetaEditorConfigurationAdapterFactory
