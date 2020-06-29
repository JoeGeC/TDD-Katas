using System.Collections.Generic;

namespace Snap_Joe_Khoovi
{
    public class StubDeck : Deck
    {
        public readonly List<Card> CardsToAdd = new List<Card>();
        
        public override void Shuffle()
        {
            Cards.Clear();
            foreach (var card in CardsToAdd)
            {
                Cards.Add(card);
            }
        }
    }
}