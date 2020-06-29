using System.Collections.Generic;
using NUnit.Framework;

namespace Snap_Joe_Khoovi
{
    public class SnapGameShould
    {
        private StubDeck _deck;
        private ConsoleSpy _consoleSpy;
        private SnapGame _snapGame;
        private StubPlayer _bob;
        private StubPlayer _john;
        
        [SetUp]
        public void SetUp()
        {
            _deck = new StubDeck();
            _consoleSpy = new ConsoleSpy();
            _bob = new StubPlayer("Bob");
            _john = new StubPlayer("John");
            var players = new List<Player> { _bob, _john };
            _snapGame = new SnapGame(players, _deck, _consoleSpy);
        }
        
        [Test]
        public void DealHandsToPlayers()
        {
            _snapGame.Deal();
            
            Assert.AreEqual(26, _bob.Hand.Count);
            Assert.AreEqual(26, _john.Hand.Count);
            Assert.AreEqual(0, _snapGame.Deck.Cards.Count);
        }

        [Test]
        public void PlayTwoTurns_AndTie()
        {
            _deck.CardsToAdd.Add(new Card(Rank.King, Suit.Spade));
            _deck.CardsToAdd.Add(new Card(Rank.Ace, Suit.Heart));
            
            _snapGame.Play();
            
            Assert.AreEqual("Bob turns card 'KS'\n" +
                            "John turns card 'AH'\n" +
                            "Game is a draw!", 
                    _consoleSpy.Result);
        }

        [Test]
        public void PlayTwoTurns_AndBobWins()
        {
            _deck.CardsToAdd.Add(new Card(Rank.King, Suit.Spade));
            _deck.CardsToAdd.Add(new Card(Rank.King, Suit.Heart));
            _bob.ReactionTime = 100;
            _john.ReactionTime = 500;
            
            _snapGame.Play();
            
            Assert.AreEqual("Bob turns card 'KS'\n" +
                            "John turns card 'KH'\n" +
                            "SNAP! Bob is the winner!!", 
                _consoleSpy.Result);
        }
        
        [Test]
        public void PlayTwoTurns_AndJohnWins()
        {
            _deck.CardsToAdd.Add(new Card(Rank.King, Suit.Spade));
            _deck.CardsToAdd.Add(new Card(Rank.King, Suit.Heart));
            _bob.ReactionTime = 500;
            _john.ReactionTime = 100;
            
            _snapGame.Play();
            
            Assert.AreEqual("Bob turns card 'KS'\n" +
                            "John turns card 'KH'\n" +
                            "SNAP! John is the winner!!", 
                _consoleSpy.Result);
        }

        [Test]
        public void PlayThreeTurns_AndWin()
        {
            _deck.CardsToAdd.Add(new Card(Rank.King, Suit.Spade));
            _deck.CardsToAdd.Add(new Card(Rank.Two, Suit.Spade));
            _deck.CardsToAdd.Add(new Card(Rank.Ace, Suit.Spade));
            _deck.CardsToAdd.Add(new Card(Rank.King, Suit.Heart));
            _bob.ReactionTime = 500;
            _john.ReactionTime = 100;
            
            _snapGame.Play();

            Assert.AreEqual("Bob turns card 'AS'\n" +
                            "John turns card 'KH'\n" +
                            "Bob turns card 'KS'\n" +
                            "SNAP! John is the winner!!", 
                _consoleSpy.Result);
        }
    }
}