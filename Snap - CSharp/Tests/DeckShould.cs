using System.Collections.Generic;
using NUnit.Framework;

namespace Snap_Joe_Khoovi
{
    public class DeckShould
    {
        private Deck _deck = new Deck();
        
        [SetUp]
        public void SetUp()
        {
            _deck = new Deck();
        }

        [Test]
        public void Have52UniqueCards()
        {
            var cards = new List<Card>();
            foreach (var currentCard in _deck.Cards)
            {
                foreach (var newCard in cards)
                {
                    Assert.AreNotEqual(currentCard.ToString(), newCard.ToString());
                }
                cards.Add(currentCard);
            }
        }

        [Test]
        public void Shuffle()
        {
            var currentCards = _deck.Cards;
            _deck.Shuffle();
            Assert.AreNotEqual(currentCards, _deck.Cards);
        }

        [Test]
        public void DealACard()
        {
            _deck.DealACard();
            Assert.AreEqual(51, _deck.Cards.Count);
        }
    }
}