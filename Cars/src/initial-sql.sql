delete from USER;
delete from ADDRESS;
delete from COMPANY;
delete from APPLICANT;
delete from CONTACT;
delete from DISCONTINUEDSTUDENT;
delete from EXAM;
delete from EXMATRICULATEDSTUDENT;
delete from IMMATRICULATEDSTUDENT;
delete from MANIPEL;
delete from STUDENT;
delete from ZENTURIE;
delete from STUDENT_EXAM;
insert into USER (ID, NAME, PASSWORD) values (1, 'ADMIN', 'Password');
insert into ADDRESS (ID, ADDITION, CITY, EMAIL, FAX, HOUSE_NUMBER, POSTCODE, STREET, TELEPHONE_NUMBER) values (1,'','Musterstadt','muster@mail.com',0123456789,'1',12345,'Musterstra�e',0123456789);
insert into ADDRESS (ID, ADDITION, CITY, EMAIL, FAX, HOUSE_NUMBER, POSTCODE, STREET, TELEPHONE_NUMBER) values (2,'','Musterstadt','muster2@mail.com',0123456788,'2',12345,'Musterstra�e',0123456788);
insert into ADDRESS (ID, ADDITION, CITY, EMAIL, FAX, HOUSE_NUMBER, POSTCODE, STREET, TELEPHONE_NUMBER) values (3,'','Musterstadt','muster3@mail.com',0123456787,'3',12345,'Musterstra�e',0123456787);
insert into APPLICANT (ID, DAY_OF_BIRTH, FIRST_NAME, GENDER, NAME, PLACE_OF_BIRTH,SALUTATION,ADDRESS_ID) values (1,'01.01.1990','Max','m�nnlich','Muster','Stadt','Herr',1);
insert into APPLICANT (ID, DAY_OF_BIRTH, FIRST_NAME, GENDER, NAME, PLACE_OF_BIRTH,SALUTATION,ADDRESS_ID) values (2,'01.02.1990','Max','m�nnlich','Master','Stadt','Herr',2);
insert into APPLICANT (ID, DAY_OF_BIRTH, FIRST_NAME, GENDER, NAME, PLACE_OF_BIRTH,SALUTATION,ADDRESS_ID) values (3,'01.03.1990','Max','m�nnlich','Mester','Stadt','Herr',3);
insert into COMPANY (ID, ABBREVIATION, ADDITION, NAME, ADDRESS_ID) VALUES (1,'MMF','GmbH','Max Mustermann Firma',1);
insert into EXAM (ID, GRADE, NAME) VALUES (1,100,'Musterpr�fung');
insert into CONTACT (FIRST_NAME, NAME, COMPANY_ID, CONTACT_ID) VALUES ('Bernd','Betreuer',1,1);
insert into CONTACT (FIRST_NAME, NAME, COMPANY_ID, CONTACT_ID) VALUES ('Barbara','Betreuer',1,2);
insert into MANIPEL (ID, COURSE_OF_STUDY, VINTAGE) VALUES (1,'Musterbezeichnung','2011');
insert into ZENTURIE (ID, NAME, MANIPEL_ID, ZENTURIE_ID) VALUES (1,'M',1,1);
insert into STUDENT (EXAM, MATRICULATION_NUMBER, APPLICANT_ID, COMPANY_ID, MANIPEL_ID, STUDENT_ID, ZENTURIE_ID) VALUES ('Musterpr�fung',0001,1,1,1,1,1)
insert into STUDENT (EXAM, MATRICULATION_NUMBER, APPLICANT_ID, COMPANY_ID, MANIPEL_ID, STUDENT_ID, ZENTURIE_ID) VALUES ('Musterpr�fung',0002,2,1,1,2,1)
insert into STUDENT (EXAM, MATRICULATION_NUMBER, APPLICANT_ID, COMPANY_ID, MANIPEL_ID, STUDENT_ID, ZENTURIE_ID) VALUES ('Musterpr�fung',0003,3,1,1,3,1)
insert into STUDENT_EXAM (STUDENT_ID, EXAM_ID) VALUES (3,1);
insert into MANIPEL_EXAM (MANIPEL_ID, EXAM_ID) VALUES (1,1);
insert into ZENTURIE_EXAM (ZENTURIE_ID, EXAM_ID) VALUES (1,1);
insert into DISCONTINUEDSTUDENT (STUDENT_ID) VALUES (1);
insert into EXMATRICULATEDSTUDENT (STUDENT_ID) VALUES (2);
insert into IMMATRICULATEDSTUDENT (USER_IDENTIFICATION, STUDENT_ID, ZENTURIE_ID) VALUES (12345,3,1);
