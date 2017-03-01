insert into CATEGORIE(nom_categorie) values
	('geographie'),
	('histoire'),
	('mathematique'),
	('connaissance genarale');
insert into NIVEAU_QUESTION(rank_niveau,nom_niveau) values 
	('1','Facile'),
	('2','Moyenne'),
	('3','difficile'),
	('4','extreme');
insert into Question(id_categorie,id_niveau,question) values 
	('1','1','Le 14 Juillet existe-t-il en Tanzanie?'),
	('3','2','Combien de jours d''anniversaires a une personne qui a vecu 50 ans?'),
	('3','2','Combien y a t-il de 7 entre 0 et 100?'), 
	('4','1','Un homme peut-il se marier avec la soeur de sa veuve?'),
	('3','2','Je divise 40 par 1/2, je multiplie le tout par 2, et j''enleve 60. Combien me reste-t-il?'),  
	('4','2','Certains mois de l''annee comptent 31 jours. Combien en ont 28?'),  
	('3','1','Il y a 10 prunes. VOus en prenez 4. Combien en avez-vous?'),  
	('3','3','Votre medecin vous prescrit des cachets a prendre toutes les demi-heures. Il vous en donne 3. Durant combien de temps prendrez-vous avec ces 3 cachets?'),  
	('4','1','Un esquimau possede 23 chiens de traineau Avant une expédition, une maladie les suprend, et tous meurent sauf 7. Combien en reste-il à l''esquimau pour tirer le traîneau ?'),  
	('4','3','Combien d''animaux de chaque sexe Moïse emmena t-il sur son arche ?'),  
	('4','2','Combien d''animaux arrivent à manger avec leur queue ?'),  
	('3','2','Combien y a t-il de paires de chaussettes dans une vingtaine ?'),  
	('4','1','Combien y a-t-il de ''f'' dans la phrase : finished files are the result of years of scientific study combined with the experience of years ?'),  
	('4','2','Quelle est la couleur d''une boîte noire d''avion de ligne civil ?'),  
	('2','2','Combien de temps a duré la guerre de cent ans ?'),  
	('4','3','De quel pays proviennent les groseilles chinoises ?'),  
	('4','3','En quelle matière est fait un pinceau en poils de chameau ?'),  
	('2','2','Quel est le prénom du roi George VI ?'),  
	('3','3','Un Canard pond un oeuf toutes les 2 heures. Combien de temps va t-il prendre pour pondre 3 oeufs ?'),  
	('3','2','Il faut 3 minutes pour cuire 1 oeuf à la coque. Combien de temps faut-il pour en cuire 2 ?'),  
	('4','1','Vous entrez dans une pièce une allumette à la main. Il fait noir dans cette pièce et il n''y a pas d''électricité mais une bougie, une cuisinière à gaz et une lampe à pétrole. Qu''allumez-vous en'),  
	('4','2','Vous mettez votre réveil à sonner à 9h du matin et vous vous couchez à 8h. Combien de temps pouvez-vous dormir ?'),  
	('3','3','Un nénuphar, sur un étang, double de taille chaque jour. Au bout de 100 jours, il recouvre entièrement l''étang. En combien de jours en recouvre-t-il la moitié ?');
insert into REPONSE(id_question,reponse,ifvrai) values 
	(1,'oui','1'), 
	(1,'non','0'), 
	(1,'peut-etre','0'),
	(1,'je ne sais pas','0'),

	(2,'0','0'), 
	(2,'1','1'), 
	(2,'49','0'), 
	(2,'50','0'), 

	(3,'7','0'), 
	(3,'11','0'),
	(3,'19','11'),
	(3,'15','0'), 

	(4,'oui','0'), 
	(4,'oui,mais c''est tres mal vu ','0'), 
	(4,'non','15'), 
	(4,'peut-etre, si elle est belle','0'),

	(5,'-20','0'),
	(5,'0','0'),
	(5,'100','19'),
	(5,'80','0'),

	(6,'0','0'),
	(6,'1','0'),
	(6,'12','23'),
	(6,'6','0'),

	(7,'0','0'),
	(7,'4','26'),
	(7,'6','0'),
	(7,'10','0'),

	(8,'1 demie-heure','0'),
	(8,'1 heure','30'),
	(8,'1 heure et demie','0'),
	(8,'2 heures','0'),

	(9,'Aucun','0'),
	(9,'1','0'),
	(9,'7','35'),
	(9,'16','0'),

	(10,'0','37'),
	(10,'1','0'),
	(10,'2','0'),
	(10,'Tous les animaux qui existent','0'),

	(11,'Aucun','0'),
	(11,'Un seul, l''ornithorynque','0'),
	(11,'Une vingtaine d''espèces','0'),
	(11,'Tous ceux qui en ont une','44'),

	(12,'0','0'),
	(12,'10','0'),
	(12,'20','47'),
	(12,'40','0'),

	(13,'2','0'),
	(13,'4','0'),
	(13,'5','0'),
	(13,'6','52'),

	(14,'Noire - Marron','0'),
	(14,'Bleue (clair / foncé)','0'),
	(14,'Orange - Jaune','55'),
	(14,'Gris métalisée','0'),
	
	(15,'99','0'),
	(15,'100','0'),
	(15,'101','0'),
	(15,'+ de 130 ans','60'),

	(16,'Maroc','0'),
	(16,'Japon','0'),
	(16,'Nouvelle-Zélande','63'),
	(16,'Chine','0'), 

	(17,'En hermine','0'),
	(17,'En poil de chameau','0'),
	(17,'En fourrure d''écureuil','67'),
	(17,'En tiges de thym séchées','0'),

	(18,'Godefroy','0'),
	(18,'Ghislain','0'),
	(18,'Albert','71'),	
	(18,'Richard','0'),

	(19,'0 h','73'),
	(19,'2 h','0'),
	(19,'3 h','0'),
	(19,'6 h','0'),

	(20,'1 mn','0'),
	(20,'3 mn','78'),
	(20,'6 mn','0'),
	(20,'9 mn','0'),

	(21,'La bougie','0'),
	(21,'La cuisinière à gaz','0'),
	(21,'La Lampe à pétrole','0'),
	(21,'Rien de tout cela','84'),

	(22,'1 h','85'),
	(22,'4 h','0'),
	(22,'7 h','0'),
	(22,'13 h','0'),

	(23,'10 jours','0'),
	(23,'49 jours','0'),
	(23,'50 jours','0'),
	(23,'99 jours','92');