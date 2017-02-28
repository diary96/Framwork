drop index CATEGORIE_PK;

drop table CATEGORIE;

drop index ASSOCIATION_JOUEUR_HISTORIQUE_F;

drop index HISTORIQUE_MOT_DE_PASSE_PK;

drop table HISTORIQUE_MOT_DE_PASSE;

drop index JOUEUR_PK;

drop table JOUEUR;

drop index NIVEAU_QUESTION_PK;

drop table NIVEAU_QUESTION;

drop index ASSOCIATION_NIVEAU_QUESTION_FK;

drop index ASSOCIATION_QUESTION_CATEGORIE_;

drop index QUESTION_PK;

drop table QUESTION;

drop index ASSOCIATION_QUESTION_REPONSE_FK;

drop index REPONSE_PK;

drop table REPONSE;

/*==============================================================*/
/* Table : CATEGORIE                                            */
/*==============================================================*/
create table CATEGORIE (
   ID_CATEGORIE         SERIAL               not null,
   NOM_CATEGORIE        VARCHAR(150)         not null,
   constraint PK_CATEGORIE primary key (ID_CATEGORIE)
);

/*==============================================================*/
/* Index : CATEGORIE_PK                                         */
/*==============================================================*/
create unique index CATEGORIE_PK on CATEGORIE (
ID_CATEGORIE
);

/*==============================================================*/
/* Table : HISTORIQUE_MOT_DE_PASSE                              */
/*==============================================================*/
create table HISTORIQUE_MOT_DE_PASSE (
   ID_HISTORIQUE        SERIAL               not null,
   ID_JOUEUR            INT4                 not null,
   MOT_DE_PASSE_HISTORIQUE VARCHAR(50)          not null,
   DATE_AJOUT_HISTORIQUE DATE                 not null,
   constraint PK_HISTORIQUE_MOT_DE_PASSE primary key (ID_HISTORIQUE)
);

/*==============================================================*/
/* Index : HISTORIQUE_MOT_DE_PASSE_PK                           */
/*==============================================================*/
create unique index HISTORIQUE_MOT_DE_PASSE_PK on HISTORIQUE_MOT_DE_PASSE (
ID_HISTORIQUE
);

/*==============================================================*/
/* Index : ASSOCIATION_JOUEUR_HISTORIQUE_F                      */
/*==============================================================*/
create  index ASSOCIATION_JOUEUR_HISTORIQUE_F on HISTORIQUE_MOT_DE_PASSE (
ID_JOUEUR
);

/*==============================================================*/
/* Table : JOUEUR                                               */
/*==============================================================*/
create table JOUEUR (
   ID_JOUEUR            SERIAL               not null,
   NOM_JOUEUR           VARCHAR(100)         not null,
   NAISSANCE_JOUEUR     DATE                 not null,
   EMAIL_JOUEUR         VARCHAR(50)          not null,
   MOT_DE_PASSE_JOUEUR  VARCHAR(50)          not null,
   constraint PK_JOUEUR primary key (ID_JOUEUR)
);

/*==============================================================*/
/* Index : JOUEUR_PK                                            */
/*==============================================================*/
create unique index JOUEUR_PK on JOUEUR (
ID_JOUEUR
);

/*==============================================================*/
/* Table : NIVEAU_QUESTION                                      */
/*==============================================================*/
create table NIVEAU_QUESTION (
   ID_NIVEAU            SERIAL               not null,
   RANK_NIVEAU          INT4                 not null,
   NOM_NIVEAU           VARCHAR(100)         not null,
   constraint PK_NIVEAU_QUESTION primary key (ID_NIVEAU)
);

/*==============================================================*/
/* Index : NIVEAU_QUESTION_PK                                   */
/*==============================================================*/
create unique index NIVEAU_QUESTION_PK on NIVEAU_QUESTION (
ID_NIVEAU
);

/*==============================================================*/
/* Table : QUESTION                                             */
/*==============================================================*/
create table QUESTION (
   ID_QUESTION          SERIAL               not null,
   ID_CATEGORIE         INT4                 not null,
   ID_NIVEAU            INT4                 not null,
   QUESTION             TEXT                 not null,
   constraint PK_QUESTION primary key (ID_QUESTION)
);

/*==============================================================*/
/* Index : QUESTION_PK                                          */
/*==============================================================*/
create unique index QUESTION_PK on QUESTION (
ID_QUESTION
);

/*==============================================================*/
/* Index : ASSOCIATION_QUESTION_CATEGORIE_                      */
/*==============================================================*/
create  index ASSOCIATION_QUESTION_CATEGORIE_ on QUESTION (
ID_CATEGORIE
);

/*==============================================================*/
/* Index : ASSOCIATION_NIVEAU_QUESTION_FK                       */
/*==============================================================*/
create  index ASSOCIATION_NIVEAU_QUESTION_FK on QUESTION (
ID_NIVEAU
);

/*==============================================================*/
/* Table : REPONSE                                              */
/*==============================================================*/
create table REPONSE (
   ID_REPONSE           SERIAL               not null,
   ID_QUESTION          INT4                 not null,
   REPONSE              TEXT                 not null,
   IFVRAI               INT4                 not null,
   constraint PK_REPONSE primary key (ID_REPONSE)
);

/*==============================================================*/
/* Index : REPONSE_PK                                           */
/*==============================================================*/
create unique index REPONSE_PK on REPONSE (
ID_REPONSE
);

/*==============================================================*/
/* Index : ASSOCIATION_QUESTION_REPONSE_FK                      */
/*==============================================================*/
create  index ASSOCIATION_QUESTION_REPONSE_FK on REPONSE (
ID_QUESTION
);

alter table HISTORIQUE_MOT_DE_PASSE
   add constraint FK_HISTORIQ_ASSOCIATI_JOUEUR foreign key (ID_JOUEUR)
      references JOUEUR (ID_JOUEUR)
      on delete restrict on update restrict;

alter table QUESTION
   add constraint FK_QUESTION_ASSOCIATI_NIVEAU_Q foreign key (ID_NIVEAU)
      references NIVEAU_QUESTION (ID_NIVEAU)
      on delete restrict on update restrict;

alter table QUESTION
   add constraint FK_QUESTION_ASSOCIATI_CATEGORI foreign key (ID_CATEGORIE)
      references CATEGORIE (ID_CATEGORIE)
      on delete restrict on update restrict;

alter table REPONSE
   add constraint FK_REPONSE_ASSOCIATI_QUESTION foreign key (ID_QUESTION)
      references QUESTION (ID_QUESTION)
      on delete restrict on update restrict;
