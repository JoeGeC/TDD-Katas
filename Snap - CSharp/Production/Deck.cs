using System;
using System.Collections.Generic;
using System.Linq;

namespace Snap_Joe_Khoovi
{
    public class Deck
    {
        public List<Card> Cards { get; private set; }

        public Deck()
        {
            CreateDeck();
        }

        private void CreateDeck()
        {
            Cards = new List<Card>();
            foreach (Suit suit in Enum.GetValues(typeof(Suit)))
            {
                foreach (Rank rank in Enum.GetValues(typeof(Rank)))
                {
                    Cards.Add(new Card(rank, suit));
                }   
            }
        }

        public virtual void Shuffle()
        {
            Cards = Cards.OrderBy(a => Guid.NewGuid()).ToList();
        }

        public Card DealACard()
        {
            Card card = Cards.First();
            Cards.Remove(card);
            return card;
        }
    }
}