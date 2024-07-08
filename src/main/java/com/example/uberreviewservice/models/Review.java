package com.example.uberreviewservice.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity                //jis class ke upar ye annotation lagaoge wo ek table ban jayega humare databse me
@Table(name = "bookingreview") //agar ye annotation hi daloge to ye class name ko uthake hi tabkle name bhi bana dega , so for cutome table name we use this
public class Review extends BaseModel{

    @Column(nullable = false)
    private String content;

    private Double rating;  //agar column annotation nhi bhi daloge to column bana deega , lekin column annotation dalke constraint add kar skte ho

    @Override
    public String toString() {
        return "Review: " + this.content + " " + this.rating + " " + this.createdAt + " " + this.updatedAt;
    }


}

/*
    Note :entity annotation me bhi name property h , ye annotation java layer yani humare codebase ke layer pe hi rheag , agar ye class kisi dure class se communictae karega to we use review , aur agar custom name dalna h to enity ke andar name dalo , aur usko apne java layer me use kar skte ho wo name )name only na ki booking review
    on the other hand table annotation ke andar jo name dale ho wo database layer pe rhega , databse pe is table se jo bhi karwana hoga wo hum bookingreview name se karenge
*/
