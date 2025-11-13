/***************************************************************
 * Author       :	 
 * Created Date :	
 * Version      : 	
 * History  :	
 * *************************************************************/
package com.chat.app.Enitity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

/**
 * FriendRequestEntity Class.
 * <p>
 * </p>
 *
 * @author kyi min khant
 */

@Entity
@Data
@Table(name = "friend_requests")
public class FriendRequestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private UserEntity sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private UserEntity receiver;

    @Enumerated(EnumType.STRING)
    private RequestStatus status = RequestStatus.PENDING;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt = new Date();

    public enum RequestStatus {
        PENDING, ACCEPTED, REJECTED
    }

    // Getters and Setters
}
