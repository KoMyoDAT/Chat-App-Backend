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
 * PasswordResetTokenEntity Class.
 * <p>
 * </p>
 *
 * @author kyi min khant
 */

@Entity
@Data
@Table(name = "password_reset_tokens")
public class PasswordResetTokenEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String token;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @Temporal(TemporalType.TIMESTAMP)
    private Date expiryDate;

    // Getters and Setters
}

