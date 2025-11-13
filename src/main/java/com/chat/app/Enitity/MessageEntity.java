/***************************************************************
 * Author       :	 
 * Created Date :	
 * Version      : 	
 * History  :	
 * *************************************************************/
package com.chat.app.Enitity;
import jakarta.persistence.*;

import java.util.Date;

/**
 * MessageEntity Class.
 * <p>
 * </p>
 *
 * @author kyi min khant
 */

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "messages")
public class MessageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Sender and receiver for private chat
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sender_id", nullable = false)
    private UserEntity sender;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receiver_id")
    private UserEntity receiver;  // null if message is sent to group

    // Group reference (if group chat)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private GroupChatEntity group;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Column(name = "is_read", nullable = false)
    private boolean read = false;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "sent_at", nullable = false, updatable = false)
    private Date sentAt = new Date();

    // Constructors
    public MessageEntity() {}

    public MessageEntity(UserEntity sender, UserEntity receiver, GroupChatEntity group, String content) {
        this.sender = sender;
        this.receiver = receiver;
        this.group = group;
        this.content = content;
    }

    // Getters and Setters
    // (optional: use Lombok to reduce boilerplate)
}
