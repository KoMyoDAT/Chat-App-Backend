/***************************************************************
 * Author       :	 
 * Created Date :	
 * Version      : 	
 * History  :	
 * *************************************************************/
package com.chat.app.Enitity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.*;

/**
 * GroupChatEntity Class.
 * <p>
 * </p>
 *
 * @author kyi min khant
 */

@Entity
@Data
@Table(name = "group_chats")
public class GroupChatEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String groupName;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private UserEntity createdBy;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt = new Date();

    @ManyToMany
    @JoinTable(
            name = "group_members",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<UserEntity> members = new HashSet<>();

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    private List<MessageEntity> messages = new ArrayList<>();

    // Getters and Setters
}
