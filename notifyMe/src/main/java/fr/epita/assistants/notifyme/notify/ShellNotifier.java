package fr.epita.assistants.notifyme.notify;

public class ShellNotifier implements INotificationSender {
    private boolean isStdErr;

    public ShellNotifier(final boolean parStdErr){
        this.isStdErr = parStdErr;
    }

    @Override
    public void notify(final String parSender, final String parReceiver, final String parMessage) {
        String output = "Notification from " + parSender + " to " + parReceiver + " received: " + parMessage;
        if (this.isStdErr) {
            System.err.println(output);
        }
        else {
            System.out.println(output);
        }
    }
}

