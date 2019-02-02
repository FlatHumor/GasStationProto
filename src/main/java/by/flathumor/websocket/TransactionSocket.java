package by.flathumor.websocket;

import by.flathumor.entity.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


@ApplicationScoped
@ServerEndpoint("/tsock")
public class TransactionSocket
{
    private static Set<TransactionSocket> peers = Collections.synchronizedSet(new HashSet<TransactionSocket>());
    private static final Log log = LogFactory.getLog(TransactionSocket.class);
    private Session wSession;
    private User user;
    private org.hibernate.Session hSession;
    private final static Object lock = new Object();

    public TransactionSocket() {

    }

    @OnMessage
    public String onMessage(String message) {
        log.debug(message);
        System.out.println("OnMessage: " + message);
        return "OnMessage: " + message;
    }

    @OnOpen
    public void onOpen(Session wSession) {
        log.debug("OnOpen: " + wSession.getQueryString());
        System.out.println("OnOpen: " + wSession.getQueryString());
        this.wSession = wSession;
        peers.add(this);
    }

    @OnClose
    public void onClose(Session wSession) {
        log.debug("OnClose");
        peers.remove(this);
    }

    private static void broadcast(String message)
    {
        for (TransactionSocket peer : peers)
        {
            try {
                synchronized (lock) {
                    peer.wSession.getBasicRemote().sendText(message);
                }
            }
            catch (IOException ioe) {
                log.error(ioe.getMessage());
            }
        }
    }
}
