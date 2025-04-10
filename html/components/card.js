export const Card = ({ pokemon }) => {
    return `
        <div class="pokemon-card ${pokemon.find ? 'active' : ''}" id="${pokemon.name}">
            <p>#${pokemon.pokedex_number}</p>
            <img src="${pokemon.sprite}" alt="${pokemon.name}" width="60px"/>
            <h2>${pokemon.name}</h2>
        </div>
    `;
};