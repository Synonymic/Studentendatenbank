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
insert into USER (ID, NAME, PASSWORD) values (2, 'Verwalter', 'Start123');
insert into ADDRESS (ID, ADDITION, CITY, EMAIL, FAX, HOUSE_NUMBER, POSTCODE, STREET, TELEPHONE_NUMBER) values (1,'','Hamburg','mail@web.com',040987654,'1',20097,'Hamburgstra�e',040987655);
insert into ADDRESS (ID, ADDITION, CITY, EMAIL, FAX, HOUSE_NUMBER, POSTCODE, STREET, TELEPHONE_NUMBER) values (2,'','Berlin','mail@mail.com',030123654,'2',03265,'Berlinstra�e',030126655);
insert into ADDRESS (ID, ADDITION, CITY, EMAIL, FAX, HOUSE_NUMBER, POSTCODE, STREET, TELEPHONE_NUMBER) values (3,'','Stuttgart','mail@gmx.com',072165458,'3',63258,'Stuttgartstra�e',072165459);
insert into ADDRESS (ID, ADDITION, CITY, EMAIL, FAX, HOUSE_NUMBER, POSTCODE, STREET, TELEPHONE_NUMBER) values (4,'','Hamburg','memail@web.com',040456456,'1',20100,'K�lnstra�e',040987655);
insert into ADDRESS (ID, ADDITION, CITY, EMAIL, FAX, HOUSE_NUMBER, POSTCODE, STREET, TELEPHONE_NUMBER) values (5,'','K�ln','email@mail.com',020123654,'2',56320,'Schanzenstra�e',020123655);
insert into ADDRESS (ID, ADDITION, CITY, EMAIL, FAX, HOUSE_NUMBER, POSTCODE, STREET, TELEPHONE_NUMBER) values (6,'','M�nchen','email@gmx.com',082165458,'3',73258,'Allianzstra�e',082165459);
insert into APPLICANT (ID, DAY_OF_BIRTH, FIRST_NAME, GENDER, NAME, PLACE_OF_BIRTH,SALUTATION,ADDRESS_ID) values (1,'01.01.1990','Bettina','female','B�cker','Homburg','Frau',1);
insert into APPLICANT (ID, DAY_OF_BIRTH, FIRST_NAME, GENDER, NAME, PLACE_OF_BIRTH,SALUTATION,ADDRESS_ID) values (2,'25.02.1992','Max','male','M�ller','K�ln','Herr',2);
insert into APPLICANT (ID, DAY_OF_BIRTH, FIRST_NAME, GENDER, NAME, PLACE_OF_BIRTH,SALUTATION,ADDRESS_ID) values (3,'11.03.1995','Nico','male','Niedermayer','Stade','Herr',3);
insert into APPLICANT (ID, DAY_OF_BIRTH, FIRST_NAME, GENDER, NAME, PLACE_OF_BIRTH,SALUTATION,ADDRESS_ID) values (4,'01.11.1989','Hans','male','Heiser','Elmshorn','Herr',4);
insert into COMPANY (ID, ABBREVIATION, ADDITION, NAME, ADDRESS_ID) VALUES (1,'GWS','GmbH','Klempner Mayer',5);
insert into COMPANY (ID, ABBREVIATION, ADDITION, NAME, ADDRESS_ID) VALUES (2,'ITC','GmbH','IT Consulting',6);
insert into EXAM (ID, GRADE, NAME) VALUES (1,100,'Controlling');
insert into EXAM (ID, GRADE, NAME) VALUES (2,83,'Internet Anwendungsarchitektur');
insert into CONTACT (FIRST_NAME, NAME, COMPANY_ID) VALUES ('Stephan','Schlosser',1);
insert into CONTACT (FIRST_NAME, NAME, COMPANY_ID) VALUES ('Barbara','Bl�mchen',1);
insert into CONTACT (FIRST_NAME, NAME, COMPANY_ID) VALUES ('Ursula','Untermann',2);
insert into CONTACT (FIRST_NAME, NAME, COMPANY_ID) VALUES ('Gerhard','Gooternicht',2);
insert into MANIPEL (ID, COURSE_OF_STUDY, VINTAGE) VALUES (1,'Wirtschaftingenieurwesen','2011');
insert into MANIPEL (ID, COURSE_OF_STUDY, VINTAGE) VALUES (2,'Wirtschaftsinformatik','2011');
insert into ZENTURIE (ID, NAME, MANIPEL_ID) VALUES (1,'W',1);
insert into ZENTURIE (ID, NAME, MANIPEL_ID) VALUES (2,'I',2);
insert into STUDENT (EXAM, MATRICULATION_NUMBER, APPLICANT_ID, COMPANY_ID, MANIPEL_ID, STUDENT_ID, ZENTURIE_ID, CONTACT_ID) VALUES ('Controlling',1,1,1,1,1,1,1)
insert into STUDENT (EXAM, MATRICULATION_NUMBER, APPLICANT_ID, COMPANY_ID, MANIPEL_ID, STUDENT_ID, ZENTURIE_ID, CONTACT_ID) VALUES ('Controlling',2,2,1,1,2,1,1)
insert into STUDENT (EXAM, MATRICULATION_NUMBER, APPLICANT_ID, COMPANY_ID, MANIPEL_ID, STUDENT_ID, ZENTURIE_ID, CONTACT_ID) VALUES ('Internet Anwendungsarchitektur',3,3,2,2,3,2,2)
update ZENTURIE set STUDENT_ID = 1 WHERE ID = 1
update ZENTURIE set STUDENT_ID = 3 WHERE ID = 2
insert into STUDENT_EXAM (STUDENT_ID, EXAM_ID) VALUES (3,1);
insert into STUDENT_EXAM (STUDENT_ID, EXAM_ID) VALUES (1,2);
insert into MANIPEL_EXAM (MANIPEL_ID, EXAM_ID) VALUES (2,1);
insert into MANIPEL_EXAM (MANIPEL_ID, EXAM_ID) VALUES (1,2);
insert into ZENTURIE_EXAM (ZENTURIE_ID, EXAM_ID) VALUES (1,2);
insert into ZENTURIE_EXAM (ZENTURIE_ID, EXAM_ID) VALUES (2,1);
insert into DISCONTINUEDSTUDENT (STUDENT_ID) VALUES (1);
insert into EXMATRICULATEDSTUDENT (STUDENT_ID) VALUES (2);
