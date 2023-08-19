package com.company.hrs.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "role_action")
public class RoleAction extends BaseEntity{
    @NotNull
    @ManyToOne()
    @JoinColumn(name = "role_id",referencedColumnName = "id",nullable = false)
    private Role role;
    @NotNull
    @ManyToOne()
    @JoinColumn(name = "action_id",referencedColumnName = "id",nullable = false)
    private Action action;
}
