package com.example.uberreviewservice.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Entity                //jis class ke upar ye annotation lagaoge wo ek table ban jayega humare databse me
@Table(name = "bookingreview") //agar ye annotation hi daloge to ye class name ko uthake hi tabkle name bhi bana dega , so for cutome table name we use this
public class Review {
    @Id      //this  annotation makes the id property a primary key of our table
    @GeneratedValue(strategy = GenerationType.IDENTITY) //we want our id to be handled whether by database or by some programmatic logic, so we use @GeneartedValue annotation and inside that we write waht srategy to use, Identity means autoincrement , sequenece means it will crate a new sequence table and from that table it defines that how our id should be there in the review table , this is bcoz ,user will only give the content , he doesnt have to bother about the id
    private Long id;

    /*
    since we have made the ddl-auto = update , so if the table already exists with different column , then it replaces/alters it using implemneting unldering sql ater commmand
    lekin update agar rkhe ho aur column defined kar diye to column me agar new constraint lagaoeg to wo suko alter nhi karega , isiliye humlog database migration karte h,
    if we have made it create , and made the column by ourselves , then it drops that existing table and make an ew one with this column , which is mentioned here
    if we have used validate , then it checks if the columns are same or not , if not then validation fails
    */

    @Column(nullable = false)
    private String content;

    private Double rating;  //agar column annotation nhi bhi daloge to column bana deega , lekin column annotation dalke constraint add kar skte ho

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)  //this annotation tells spring about the formats of Date object to be stored i.e. Date /Time ? Timestamp
    @CreatedDate  //this annotaion tells spring that only handle it for object creation , yani jab koi is class ka object banayega using new then only spring tum isko handle karo , user ko pas karne ki jarrorat nhi
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate  //this annotation tells spring that only handle this jab koi update kar rha hogi either using dot gar private nhi h to , ya using setter , use ko isk load lene ka jaroorat nhi h , usko ye dono volumn ki value pass karne ki jarorat nhi h , sring sambhal lega
    private Date updatedAt;

    @Override
    public String toString() {
        return "Review: " + this.content + " " + this.rating + " " + this.createdAt + " " + this.updatedAt;
    }


}

/*
    Note :entity annotation me bhi name property h , ye annotation java layer yani humare codebase ke layer pe hi rheag , agar ye class kisi dure class se communictae karega to we use review , aur agar custom name dalna h to enity ke andar name dalo , aur usko apne java layer me use kar skte ho wo name )name only na ki booking review
    on the other hand table annotation ke andar jo name dale ho wo database layer pe rhega , databse pe is table se jo bhi karwana hoga wo hum bookingreview name se karenge
*/
