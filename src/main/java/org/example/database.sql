create database if not exists recettes;
use recettes; 

create table if not exists ingredient (
	 id INT AUTO_INCREMENT PRIMARY KEY,
	 nom VARCHAR(255)
);

create table if not exists categorie (
	id INT AUTO_INCREMENT PRIMARY KEY,
	 nom VARCHAR(255)
);

create table if not exists etape (
	id INT AUTO_INCREMENT PRIMARY KEY,
	description Text
);

create table if not exists commentaire (
	id INT AUTO_INCREMENT PRIMARY KEY,
	description Text
);

create table if not exists recette (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(255),
    tempsPrep INT,
    tempsCuisson INT,
    difficulte ENUM ('Difficile', 'Intermédiaire', 'Facile'),
    categorie_id INT,
    etape_id INT,
    commentaire_id INT,
    foreign key (categorie_id) references Categorie(id),
    foreign key (etape_id) references Etape(id),
    foreign key (commentaire_id) references Commentaire(id)
);

create table if not exists RecetteIngredient (
	id int auto_increment primary key,
    idRecette int not null,
    idIngredient int not null,
    foreign key (idRecette) references Recette(id),
    foreign key (idIngredient) references Ingredient(id)
);

select * from recette;


