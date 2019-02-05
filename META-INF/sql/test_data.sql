insert into gas_station.user (id, username, real_name, password) values (100, 'MichaelVFoley@rhyta.com',          'Michael V. Foley',     '864-481-2631');
insert into gas_station.user (id, username, real_name, password) values (101, 'AlbertNHarp@rhyta.com',            'Albert N. Harp',       '720-247-8930');
insert into gas_station.user (id, username, real_name, password) values (102, 'EvaAWilliams@teleworm.us',         'Eva A. Williams',      '336-545-9250');
insert into gas_station.user (id, username, real_name, password) values (103, 'LindaJMaurice@jourrapide.com',     'Linda J. Maurice',     '724-532-7936');
insert into gas_station.user (id, username, real_name, password) values (104, 'NicholeHLarry@teleworm.us',        'Nichole H. Larry',     '650-898-7615');
insert into gas_station.user (id, username, real_name, password) values (105, 'DaleABuchanan@armyspy.com',        'Dale A. Buchanan',     '317-980-8405');
insert into gas_station.user (id, username, real_name, password) values (106, 'MandyRNorman@teleworm.us',         'Mandy R. Norman',      '573-439-5499');
insert into gas_station.user (id, username, real_name, password) values (107, 'GretchenJGriswold@jourrapide.com', 'Gretchen J. Griswold', '570-232-2889');
insert into gas_station.user (id, username, real_name, password) values (108, 'MarySDavis@teleworm.us',           'Mary S. Davis',        '972-669-4468');
insert into gas_station.user (id, username, real_name, password) values (109, 'AndrewMMiller@jourrapide.com',     'Andrew M. Miller',     '206-740-3363');
insert into gas_station.user (id, username, real_name, password) values (110, 'MelissaGHoliday@teleworm.us',      'Melissa G. Holiday',   '864-596-5642');
insert into gas_station.user (id, username, real_name, password) values (111, 'StevenVCarpenter@armyspy.com',     'Steven V. Carpenter',  '361-348-6501');


insert into gas_station.transaction (id, amount, description, payer_id, recipient_id)
values (100, 25000, 'Lorem Ipsum is simply dummy text', 100, 107);
insert into gas_station.user_transaction_rel (user_id, transaction_id) values (100, 107);

insert into gas_station.transaction (id, amount, description, payer_id, recipient_id)
values (101, 5000, 'Lorem Ipsum has been the industrys standard dummy ', 102, 107);
insert into gas_station.user_transaction_rel (user_id, transaction_id) values (102, 107);

insert into gas_station.transaction (id, amount, description, payer_id, recipient_id)
values (102, 7500, 'It is a long established fact that a reader will be distracted by the readable content', 104, 107);
insert into gas_station.user_transaction_rel (user_id, transaction_id) values (104, 107);

insert into gas_station.transaction (id, amount, description, payer_id, recipient_id)
values (103, 12400, 'Lorem Ipsum is simply dummy text', 108, 105);
insert into gas_station.user_transaction_rel (user_id, transaction_id) values (108, 105);

insert into gas_station.transaction (id, amount, description, payer_id, recipient_id)
values (104, 6700, 'The point of using Lorem Ipsum', 103, 104);
insert into gas_station.user_transaction_rel (user_id, transaction_id) values (103, 104);

insert into gas_station.transaction (id, amount, description, payer_id, recipient_id)
values (105, 10000, 'making it look like readable English', 103, 105);
insert into gas_station.user_transaction_rel (user_id, transaction_id) values (103, 105);

insert into gas_station.transaction (id, amount, description, payer_id, recipient_id)
values (106, 24000, 'Many desktop publishing packages', 105, 107);
insert into gas_station.user_transaction_rel (user_id, transaction_id) values (105, 107);

insert into gas_station.transaction (id, amount, description, payer_id, recipient_id)
values (107, 2000, 'Lorem Ipsum as their default model text', 102, 110);
insert into gas_station.user_transaction_rel (user_id, transaction_id) values (102, 110);

insert into gas_station.transaction (id, amount, description, payer_id, recipient_id)
values (108, 18000, 'search for "lorem ipsum" will uncover many web sites', 110, 107);
insert into gas_station.user_transaction_rel (user_id, transaction_id) values (110, 107);

insert into gas_station.transaction (id, amount, description, payer_id, recipient_id)
values (109, 30000, 'Various versions have evolved over the years', 109, 100);
insert into gas_station.user_transaction_rel (user_id, transaction_id) values (109, 100);

insert into gas_station.transaction (id, amount, description, payer_id, recipient_id)
values (110, 9200, 'sometimes by accident, sometimes on purpose', 106, 108);
insert into gas_station.user_transaction_rel (user_id, transaction_id) values (106, 108);

insert into gas_station.transaction (id, amount, description, payer_id, recipient_id)
values (111, 5600, 'There are many variations of passages of Lorem Ipsum', 104, 108);
insert into gas_station.user_transaction_rel (user_id, transaction_id) values (104, 108);
