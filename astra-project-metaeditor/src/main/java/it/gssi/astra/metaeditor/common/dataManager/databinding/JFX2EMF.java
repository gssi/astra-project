package it.gssi.astra.metaeditor.common.dataManager.databinding;

import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.property.INativePropertyListener;
import org.eclipse.core.databinding.property.value.IValueProperty;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.EMFUpdateValueStrategy;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.databinding.edit.IEMFEditValueProperty;
import org.eclipse.emf.databinding.edit.internal.EMFEditValueProperty;
import org.eclipse.emf.databinding.edit.internal.EMFEditValuePropertyDecorator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.fx.core.databinding.JFXBeanProperties;

import MetaEditor.MetaEditorPersistence.impl.MetaEditorPersistenceImpl;
import it.gssi.astra.metaeditor.common.LayoutScene;
import it.gssi.astra.metaeditor.common.dataManager.databinding.converters.Double2EintConverter;
import it.gssi.astra.metaeditor.common.dataManager.databinding.converters.EInt2DoubleConverter;
import it.gssi.astra.metaeditor.common.dataManager.databinding.converters.EInt2StringConverter;
import it.gssi.astra.metaeditor.common.dataManager.databinding.converters.EList2ListConverter;
import it.gssi.astra.metaeditor.common.dataManager.databinding.converters.List2EListConverter;
import it.gssi.astra.metaeditor.common.dataManager.databinding.converters.SectionList2SectionEListConverter;
import it.gssi.astra.metaeditor.common.dataManager.databinding.converters.SectionsEList2SectionListConverter;
import it.gssi.astra.metaeditor.common.dataManager.databinding.converters.String2EintConverter;
import it.gssi.astra.metaeditor.common.dataManager.databinding.customEMFUpdateValueStrategies.AtomicUpdateValueStrategy;
import it.gssi.astra.metaeditor.common.dataManager.databinding.customEMFUpdateValueStrategies.DisconnectAndReconnectStrategy;

/**
 * Wrapper of {@code org.eclipse.fx.core.databinding} APIs.
 * 
 * It allows to bind a JavaFX control value to the value of an attribute of the
 * model simply calling
 * {@link JFX2EMF#bindValues(Contexts, EObject, String, Object, String, Converters)}.
 *
 */
public class JFX2EMF {

	public enum Contexts {
		CANVAS, PERSISTENCE, BENDPOINT_POSITIONS, PROPERTY_VALUES, ANCHORPOINT_CONNECTIONS
	}

	public enum Converters {
		NONE, EINT_DOUBLE, EINT_STRING, ELIST_LIST, SECTIONS, APPLY_ATOMICITY, TRY_RECONNECTION
	}

	/**
	 * Bind the value of a JavaFX attribute to the corresponding value in the model
	 * and vice versa
	 * 
	 * @param cont          The context which will contain the returned binding
	 * @param eObject       The EMF object
	 * @param EMF_attribute The attribute of the EMF object to observe
	 * @param JFX_Object    The JavaFX object
	 * @param JFX_attribute The attribute of the JavaFX object to observe
	 * @param conv          The converter to be used (if needed)
	 * @return The created binding
	 */
	@SuppressWarnings("unchecked")
	public static Binding bindValues(Contexts cont, EObject eObject, String EMF_attribute, Object JFX_Object,
			String JFX_attribute, Converters conv) {

		EMFDataBindingContext context = null;

		EMFUpdateValueStrategy targetToModel = null;
		EMFUpdateValueStrategy modelToTarget = null;

		switch (cont) {
		case CANVAS:
			context = DataBinding.getInstance().getCanvasContext();
			break;

		case PERSISTENCE:
			context = DataBinding.getInstance().getPersistenceContext();
			break;

		case BENDPOINT_POSITIONS:
			context = DataBinding.getInstance().getBendpointPositionsContext();
			break;

		case ANCHORPOINT_CONNECTIONS:
			context = DataBinding.getInstance().getAnchorPointsContext();
			break;

		case PROPERTY_VALUES:
			context = DataBinding.getInstance().getPropertyViewContext();
			break;
		}

		switch (conv) {
		case NONE:
			return createBind(context, eObject, EMF_attribute, JFX_Object, JFX_attribute);

		case EINT_DOUBLE:

			targetToModel = new EMFUpdateValueStrategy();
			targetToModel.setConverter(new Double2EintConverter());

			modelToTarget = new EMFUpdateValueStrategy();
			modelToTarget.setConverter(new EInt2DoubleConverter());
			break;

		case EINT_STRING:

			targetToModel = new EMFUpdateValueStrategy();
			targetToModel.setConverter(new String2EintConverter());

			modelToTarget = new EMFUpdateValueStrategy();
			modelToTarget.setConverter(new EInt2StringConverter());
			break;

		case ELIST_LIST:

			targetToModel = new EMFUpdateValueStrategy();
			targetToModel.setConverter(new List2EListConverter(eObject,
					eObject.eClass().getEStructuralFeature(EMF_attribute).getFeatureID()));

			modelToTarget = new EMFUpdateValueStrategy();
			modelToTarget.setConverter(new EList2ListConverter());
			break;

		case SECTIONS:

			targetToModel = new EMFUpdateValueStrategy();
			targetToModel.setConverter(new SectionList2SectionEListConverter(eObject,
					eObject.eClass().getEStructuralFeature(EMF_attribute).getFeatureID()));

			modelToTarget = new EMFUpdateValueStrategy();
			modelToTarget.setConverter(new SectionsEList2SectionListConverter());
			return createBindForList(context, eObject, EMF_attribute, JFX_Object, JFX_attribute, targetToModel,
					modelToTarget);

		case APPLY_ATOMICITY:

			targetToModel = new AtomicUpdateValueStrategy();
			modelToTarget = new EMFUpdateValueStrategy();
			break;

		case TRY_RECONNECTION:
			targetToModel = new DisconnectAndReconnectStrategy();
			modelToTarget = new EMFUpdateValueStrategy();
			break;

		}

		return createBind(context, eObject, EMF_attribute, JFX_Object, JFX_attribute, targetToModel, modelToTarget);
	}

	/**
	 * Bind the value of a JavaFX attribute to the corresponding value in the model
	 * and vice versa with the default strategies.
	 * 
	 * @param context
	 * @param eObject
	 * @param EMF_attribute
	 * @param JFX_Object
	 * @param JFX_attribute
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private static Binding createBind(EMFDataBindingContext context, EObject eObject, String EMF_attribute,
			Object JFX_Object, String JFX_attribute) {

		IValueProperty<Object, ?> UIPropertyY = JFXBeanProperties.value(JFX_attribute);
		IObservableValue<?> observableUIPropertyY = UIPropertyY.observe(DataBinding.getInstance().getRealm(),
				JFX_Object);

		IEMFEditValueProperty modelPropertyY = EMFEditProperties.value(LayoutScene.getInstance().getEditingDomain(),
				eObject.eClass().getEStructuralFeature(EMF_attribute));

		IObservableValue<?> observableModelPropertyY = modelPropertyY.observe(DataBinding.getInstance().getRealm(),
				eObject);

		return context.bindValue(observableUIPropertyY, observableModelPropertyY);
	}

	/**
	 * Bind the value of a JavaFX attribute to the corresponding value in the model
	 * and vice versa with the provided strategies.
	 * 
	 * @param context
	 * @param eObject
	 * @param EMF_attribute
	 * @param JFX_Object
	 * @param JFX_attribute
	 * @param targetToModel
	 * @param modelToTarget
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private static Binding createBind(EMFDataBindingContext context, EObject eObject, String EMF_attribute,
			Object JFX_Object, String JFX_attribute, EMFUpdateValueStrategy targetToModel,
			EMFUpdateValueStrategy modelToTarget) {

		IValueProperty<Object, ?> UIPropertyY = JFXBeanProperties.value(JFX_attribute);
		IObservableValue<?> observableUIPropertyY = UIPropertyY.observe(DataBinding.getInstance().getRealm(),
				JFX_Object);

		IEMFEditValueProperty modelPropertyY = EMFEditProperties.value(LayoutScene.getInstance().getEditingDomain(),
				eObject.eClass().getEStructuralFeature(EMF_attribute));

		IObservableValue<?> observableModelPropertyY = modelPropertyY.observe(DataBinding.getInstance().getRealm(),
				eObject);

		return context.bindValue(observableUIPropertyY, observableModelPropertyY, targetToModel, modelToTarget);
	}

	/**
	 * Bind the value of a JavaFX attribute to the corresponding value in the model
	 * and vice versa with the provided strategies and forces target update.
	 * 
	 * @param context
	 * @param eObject
	 * @param EMF_attribute
	 * @param JFX_Object
	 * @param JFX_attribute
	 * @param targetToModel
	 * @param modelToTarget
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private static Binding createBindForList(EMFDataBindingContext context, EObject eObject, String EMF_attribute,
			Object JFX_Object, String JFX_attribute, EMFUpdateValueStrategy targetToModel,
			EMFUpdateValueStrategy modelToTarget) {

		IValueProperty<Object, ?> UIPropertyY = JFXBeanProperties.value(JFX_attribute);
		IObservableValue<?> observableUIPropertyY = UIPropertyY.observe(DataBinding.getInstance().getRealm(),
				JFX_Object);

		/*******************************************************************************************/
		// Explicitly running EMFEditProperties.value in order to get the object EMFEditValueProperty
		// necessary to add the listener that forces target update
		
		FeaturePath fp = FeaturePath.fromList(eObject.eClass().getEStructuralFeature(EMF_attribute));
		EMFEditValueProperty property = new EMFEditValueProperty(LayoutScene.getInstance().getEditingDomain(),
				fp.getFeaturePath()[0]);

		IEMFEditValueProperty featureProperty = new EMFEditValuePropertyDecorator(
				LayoutScene.getInstance().getEditingDomain(), property, fp.getFeaturePath()[0]);

		for (int i = 1; i < fp.getFeaturePath().length; i++) {
			featureProperty = featureProperty.value(fp.getFeaturePath()[i]);
		}
		/*******************************************************************************************/

		IObservableValue<?> observableModelPropertyY = featureProperty.observe(DataBinding.getInstance().getRealm(),
				eObject);

		Binding binding = context.bindValue(observableUIPropertyY, observableModelPropertyY, targetToModel,
				modelToTarget);

		// Adding the listener in this way will filter notification from model and
		// update target of only this binding
		INativePropertyListener<MetaEditorPersistenceImpl> listener = property.adaptListener(event -> {
			binding.updateModelToTarget();
		});

		listener.addTo((MetaEditorPersistenceImpl) eObject);

		return binding;
	}

}
