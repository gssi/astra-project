package it.gssi.astra.metaeditor.common.property;

import javafx.beans.binding.NumberExpression;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.IndexRange;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;

import java.math.BigInteger;


/**
 * Replacement for org.controlsfx.property.editor.NumericField which cannot be extended because it is not visible.
 * This class adds supports to Integer validation with {@link IntegerValidator} which
 * implements the check to avoid integers with wrong format like integers greater than {@value Integer.MAX_VALUE}.
 */
class NumericField extends TextField {

	private final NumericValidator<? extends Number> value;

	public NumericField(Class<? extends Number> cls) {

		if (cls == int.class || cls == Integer.class) {
			value = new IntegerValidator(this);
		} else if (cls == byte.class || cls == Byte.class || cls == short.class || cls == Short.class
				|| cls == int.class || cls == Integer.class || cls == long.class || cls == Long.class
				|| cls == BigInteger.class) {
			value = new LongValidator(this);
		} else {
			value = new DoubleValidator(this);
		}

		// Commented out to avoid setting an invalid value when focus is lost
//		focusedProperty().addListener((observable, oldValue, newValue) -> {
//			if (!newValue) {
//				value.setValue(value.toNumber(getText()));
//			}
//		});
		
		// We use the ENTER keycode instead
		this.setOnKeyPressed(event -> {
			if (KeyCode.ENTER == event.getCode()) {
				value.setValue(value.toNumber(getText()));
				NumericField.this.getParent().requestFocus();
			}
		});
	}

	public final ObservableValue<Number> valueProperty() {
		return value;
	}

	@Override
	public void replaceText(int start, int end, String text) {
		if (replaceValid(start, end, text)) {
			super.replaceText(start, end, text);
		}
	}

	@Override
	public void replaceSelection(String text) {
		IndexRange range = getSelection();
		if (replaceValid(range.getStart(), range.getEnd(), text)) {
			super.replaceSelection(text);
		}
	}

    /**
     * Sets the value of the numeric value property.
     * @param value The new value to assign.
     */
    protected void setValue(Number value) {
        this.value.setValue(value);
    }

	/**
	 * 
	 * 
	 * @param start
	 * @param end
	 * @param fragment
	 * @return false if {@link NumericValidator#toNumber(String)} returns null, true otherwise. 
	 */
	private Boolean replaceValid(int start, int end, String fragment) {
		try {
			String newText = getText().substring(0, start) + fragment + getText().substring(end);
			if (newText.isEmpty())
				return true;
			if (value.toNumber(newText) != null)
				return true;
			return false;
		} catch (Throwable ex) {
			return false;
		}
	}

	public interface NumericValidator<T extends Number> extends NumberExpression {
		void setValue(Number num);

		T toNumber(String s);

	}

	static class DoubleValidator extends SimpleDoubleProperty implements NumericValidator<Double> {

		private NumericField field;

		public DoubleValidator(NumericField field) {
			super(field, "value", 0.0); //$NON-NLS-1$
			this.field = field;
		}

		@Override
		protected void invalidated() {
			field.setText(Double.toString(get()));
		}

		@Override
		public Double toNumber(String s) {
			if (s == null || s.trim().isEmpty())
				return 0d;
			String d = s.trim();
			if (d.endsWith("f") || d.endsWith("d") || d.endsWith("F") || d.endsWith("D")) { //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
				throw new NumberFormatException("There should be no alpha symbols"); //$NON-NLS-1$
			}
			return new Double(d);
		};

	}

	static class LongValidator extends SimpleLongProperty implements NumericValidator<Long> {

		private NumericField field;

		public LongValidator(NumericField field) {
			super(field, "value", 0L); //$NON-NLS-1$
			this.field = field;
		}

		@Override
		protected void invalidated() {
			field.setText(Long.toString(get()));
		}

		@Override
		public Long toNumber(String s) {
			if (s == null || s.trim().isEmpty())
				return 0L;
			String d = s.trim();
			return new Long(d);
		}

	}

	static class IntegerValidator extends SimpleIntegerProperty implements NumericValidator<Integer> {

		private NumericField field;

		public IntegerValidator(NumericField field) {
			super(field, "value", 0); //$NON-NLS-1$
			this.field = field;
		}

		@Override
		protected void invalidated() {
			field.setText(Integer.toString(get()));
		}

		/**
		 * If this method returns null then the {@link NumericField#replaceValid(int, int, String)} will return false
		 */
		@Override
		public Integer toNumber(String s) {
			if (s == null || s.trim().isEmpty())
				return 0;
			String d = s.trim();
			try {
				int res = Integer.valueOf(d);
				return res;
			} catch (NumberFormatException ex) {
				return null;
			}
			
		}

	}

}
