package com.mtx.domain;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;


@Entity
@Table(name="Image")
public class Image {
    @Id
    @GeneratedValue(strategy=SEQUENCE, generator="images_id_seq")
    @SequenceGenerator(name="images_id_seq", sequenceName="images_id_seq", allocationSize=1)
    private Long id;

    @Column(name="title")
    private String title;

    @Column(name="url")
    private String url;

//    private String UUID














}
