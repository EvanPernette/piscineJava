package fr.epita.assistants.notifyme.user;

import java.util.ArrayList;
import java.util.List;

import fr.epita.assistants.notifyme.notify.*;


public class User implements IMultiNotificationSender {
    private String username;
    private List<INotificationSender> notificationList;

    public User(String username, List<INotificationSender> parNotificationList) {
        this.username = username;
        this.notificationList = parNotificationList;
    }

    public User(String username) {
        this.username = username;
        this.notificationList = new ArrayList<>();
    }

    public String getUsername() {
        return this.username;
    }

    @Override
    public void sendNotifications(String parRecipient, String parMessage) {
        for (INotificationSender sender : notificationList) {
            sender.notify(this.username, parRecipient, parMessage);
        }
    }

    @Override
    public void addNotifier(INotificationSender parNotifier) {
        if (parNotifier != null) {
            notificationList.add(parNotifier);
        }
    }

    @Override
    public List<INotificationSender> getNotifiers() {
        return notificationList;
    }
}