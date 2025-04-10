import { Card } from "./components/card.js";

const listeElem = document.querySelector('.pokemon-liste');
const searchBar = document.getElementById('searchBar');


searchBar.addEventListener('keyup', async (e) => {
    const searchString = e.target.value.toLowerCase();

    try {

        const response = await fetch(`http://51.38.189.49:50972/poke?idOrName=${encodeURIComponent(searchString)}`);

        if (!response.ok) {
            throw new Error(`Erreur HTTP: ${response.status}`);
        }

        const responseData = await response.json();

        displayPokemonData(responseData); // Affiche les résultats filtrés
    } catch (error) {
        console.error('Erreur lors de la récupération des données:', error);
    }

});

function displayPokemonData(pokemonData) {
    listeElem.innerHTML = ''; // Réinitialise la liste

    // Utilisation du composant Card pour générer le HTML
    const html = Card({ pokemon: pokemonData });
    listeElem.innerHTML += html;

}

listeElem.addEventListener('click', (e) => {
    const target = e.target.closest('.pokemon-card');
    if (target) {
        const pokemonName = target.id;
        console.log(`Vous avez cliqué sur le Pokémon: ${pokemonName}`);
        if (target.classList.contains('active')) {
            target.classList.remove('active');
        }
        else {
            target.classList.add('active');
        }
    }
});
