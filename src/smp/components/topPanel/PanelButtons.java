package smp.components.topPanel;

import javafx.scene.text.Text;
import smp.components.buttons.ModeButton;
import smp.components.staff.Staff;
import smp.fx.SMPFXController;

/**
 * Panel buttons that are on the top panel.
 * @author RehdBlob
 * @since 2014.05.21
 */
public class PanelButtons {

    /** The Staff that this is linked to. */
    private Staff theStaff;

    /** Mode button. */
    private ModeButton mButton;

    /** The FXML controller class. */
    private SMPFXController controller;
    
    /** Default constructor. */
    public PanelButtons(Staff s, SMPFXController ct) {
        theStaff = s;
        setController(ct);
        mButton = new ModeButton(controller.getModeButton(),
                controller.getModeText(), controller);
        mButton.setStaff(theStaff);
    }

    /**
     * Sets the controller class.
     * @param ct The FXML controller class.
     */
    public void setController(SMPFXController ct) {
        controller = ct;
    }

}