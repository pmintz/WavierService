alter table participants add (username varchar2(30), password varchar2(30));

alter table participants modify (lastname not null, firstname not null, username not null, password not null);

CREATE TABLE "MIKE"."PARTICIPANTS" 
   (	"PERSONID" NUMBER(*,0), 
	"LASTNAME" VARCHAR2(255 BYTE) NOT NULL ENABLE, 
	"FIRSTNAME" VARCHAR2(255 BYTE) NOT NULL ENABLE, 
	"CREATED" TIMESTAMP (6), 
	"WAVIER" VARCHAR2(255 BYTE), 
	"USERNAME" VARCHAR2(30 BYTE) NOT NULL ENABLE, 
	"PASSWORD" VARCHAR2(30 BYTE) NOT NULL ENABLE, 
	 CONSTRAINT "UNIQUEPERSON" UNIQUE ("LASTNAME", "FIRSTNAME")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS NOCOMPRESS LOGGING
  TABLESPACE "USERS"  ENABLE, 
	 CONSTRAINT "PRIMARYKEYPERSONID" PRIMARY KEY ("PERSONID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS NOCOMPRESS LOGGING
  TABLESPACE "USERS"  ENABLE
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
  
  create SEQUENCE sequencePersonID start with 08162018;
  
  create or replace trigger PersonIDIncrement
  before insert on participants for each row
  begin
  select sequencePersonID.NEXTVAL
  into :new.PERSONID
  from dual;
  end;
  
  