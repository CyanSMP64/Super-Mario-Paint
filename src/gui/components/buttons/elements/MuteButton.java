package smp.components.buttons;

import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import smp.ImageIndex;
import smp.ImageLoader;
import smp.components.general.ImageToggleButton;
import smp.fx.SMPFXController;
import smp.stateMachine.StateMachine;

/**
 * This is the button that, when pressed, toggles whether you are placing a mute
 * note or not.
 * 
 * @author RehdBlob
 * @since 2013.11.10
 *
 */
public class MuteButton extends ImageToggleButton {

    /** The muteA button that this mute button is linked to. */
    private MuteInstButton mt;

    /**
     * This creates a new MuteButton object.
     * 
     * @param i
     *            This <code>ImageView</code> object that you are trying to link
     *            this button with.
     * @param ct
     *            The FXML controller object.
     * @param im
     *            The Image loader object.
     */
    public MuteButton(ImageView i, SMPFXController ct, ImageLoader im) {
        super(i, ct, im);
        getImages(ImageIndex.MUTE_PRESSED, ImageIndex.MUTE_RELEASED);
        releaseImage();
        isPressed = false;
        
		// TODO: create getMuteButton() somewhere so adding a hotkey can be done elsewhere
        // @since v1.1.2 per request of seymour schlong
		ct.getBasePane().addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				/** alt+n is for deselecting notes @see <code>StaffRubberBandEventHandler</code> */
				if (controller.getNameTextField().focusedProperty().get()) return; // Disable while textfield is focused
				if(!event.isControlDown() && !event.isAltDown() && event.getCode() == KeyCode.N)
					reactPressed(null);
			}
		});
    }

    @Override
    protected void reactClicked(MouseEvent event) {
        // Do nothing

    }

    @Override
    public void reactPressed(MouseEvent event) {
        if (isPressed) {
            isPressed = false;
            releaseImage();
            StateMachine.resetMutePressed();
        } else {
            if (mt.isPressed())
                mt.reactPressed(null);
            isPressed = true;
            pressImage();
            StateMachine.setMutePressed();

        }

    }

    /**
     * @param im
     *            The mute button that we want to set.
     */
    public void setMuteButton(MuteInstButton im) {
        mt = im;
    }

    /** @return The mute button that this muteA button is linked to. */
    public ImageToggleButton getMuteButton() {
        return mt;
    }

}
