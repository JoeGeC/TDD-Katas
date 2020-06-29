using System.Collections.Generic;
using NUnit.Framework;

namespace Snap_Joe_Khoovi
{
    public class AcceptanceTest
    {
        [SetUp]
        public void Setup()
        {
        }
        
        [Test]
        public void SnapGameShouldSimulateAGameAndDisplayAWinner()
        {
            var consoleSpy = new ConsoleSpy();
            var deck = new StubDeck();
            deck.CardsToAdd.Add(new Card(Rank.Two, Suit.Diamond));
            deck.CardsToAdd.Add(new Card(Rank.Two, Suit.Club));
            deck.CardsToAdd.Add(new Card(Rank.King, Suit.Spade));
            deck.CardsToAdd.Add(new Card(Rank.Ace, Suit.Heart));
            var bob = new StubPlayer("Bob");
            var john = new StubPlayer("John");
            var players = new List<Player>{ bob, john };
            var snapGame = new SnapGame(players, deck, consoleSpy);
            bob.ReactionTime = 500;
            john.ReactionTime = 100;
            
            snapGame.Play();
            
            const string expected = "Bob turns card 'KS'\n" +
                                    "John turns card 'AH'\n" +
                                    "Bob turns card '2D'\n" +
                                    "John turns card '2C'\n" +
                                    "SNAP! John is the winner!!";
            Assert.AreEqual(expected, consoleSpy.Result);
        }
    }
}