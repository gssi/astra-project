package it.gssi.astra.metaeditor.common.property.validation;

import java.util.Arrays;
import java.util.Collection;

import org.controlsfx.control.decoration.Decoration;
import org.controlsfx.control.decoration.GraphicDecoration;
import org.controlsfx.validation.Severity;
import org.controlsfx.validation.ValidationMessage;
import org.controlsfx.validation.decoration.AbstractValidationDecoration;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class CustomGraphicValidationDecoration extends AbstractValidationDecoration {
	
    // quote: "we shouldn't hardcode this - defer to CSS eventually"
	
    private static final Image ERROR_IMAGE = new Image(CustomGraphicValidationDecoration.class.getResource("/common/img/validation/decoration-error.png").toExternalForm()); //$NON-NLS-1$
    private static final Image WARNING_IMAGE = new Image(CustomGraphicValidationDecoration.class.getResource("/common/img/validation/decoration-warning.png").toExternalForm()); //$NON-NLS-1$
    private static final Image REQUIRED_IMAGE = new Image(CustomGraphicValidationDecoration.class.getResource("/common/img/validation/required-indicator.png").toExternalForm()); //$NON-NLS-1$

    private static final String SHADOW_EFFECT = "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);"; //$NON-NLS-1$
    private static final String POPUP_SHADOW_EFFECT = "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 5, 0, 0, 5);"; //$NON-NLS-1$
    private static final String TOOLTIP_COMMON_EFFECTS = "-fx-font-weight: bold; -fx-padding: 5; -fx-border-width:1;"; //$NON-NLS-1$
    
    private static final String ERROR_TOOLTIP_EFFECT = POPUP_SHADOW_EFFECT + TOOLTIP_COMMON_EFFECTS
            + "-fx-background-color: FBEFEF; -fx-text-fill: cc0033; -fx-border-color:cc0033;"; //$NON-NLS-1$

    private static final String WARNING_TOOLTIP_EFFECT = POPUP_SHADOW_EFFECT + TOOLTIP_COMMON_EFFECTS
            + "-fx-background-color: FFFFCC; -fx-text-fill: CC9900; -fx-border-color: CC9900;"; //$NON-NLS-1$

    /**
     * Creates default instance
     */
    public CustomGraphicValidationDecoration() {

    }

    // TODO write javadoc that users should override these methods to customise
    // the error / warning / success nodes to use 
    protected Node createErrorNode() {
        return new ImageView(ERROR_IMAGE);
    }

    protected Node createWarningNode() {
        return new ImageView(WARNING_IMAGE);
    }

    protected Node createDecorationNode(ValidationMessage message) {
        Node graphic = Severity.ERROR == message.getSeverity() ? createErrorNode() : createWarningNode();
        graphic.setStyle(SHADOW_EFFECT);
        Label label = new Label();
        label.setGraphic(graphic);
        label.setTooltip(createTooltip(message));
        label.setAlignment(Pos.CENTER);
        return label;
    }

    protected Tooltip createTooltip(ValidationMessage message) {
        Tooltip tooltip = new Tooltip(message.getText());
        tooltip.setOpacity(.9);
        tooltip.setAutoFix(true);
        tooltip.setShowDelay(Duration.millis(100));
        tooltip.setStyle( Severity.ERROR == message.getSeverity()? ERROR_TOOLTIP_EFFECT: WARNING_TOOLTIP_EFFECT);
        return tooltip;
    }

    /**
     * {@inheritDoc}
     */
    @Override
	protected Collection<Decoration> createValidationDecorations(ValidationMessage message) {
    	return Arrays.asList(new GraphicDecoration(createDecorationNode(message),Pos.TOP_LEFT));
	}
    
    /**
     * {@inheritDoc}
     */
    @Override
	protected Collection<Decoration> createRequiredDecorations(Control target) {
    	return Arrays.asList(new GraphicDecoration(new ImageView(REQUIRED_IMAGE),Pos.TOP_LEFT, REQUIRED_IMAGE.getWidth()/2, REQUIRED_IMAGE.getHeight()/2));
	}

}
