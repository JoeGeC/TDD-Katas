using NUnit.Framework;

namespace Snap_Joe_Khoovi
{
    public class PlayerShould
    {
        [Test]
        public void PlayACard()
        {
            var card = new Card(Rank.Ace, Suit.Club);

            var player = new Player("Bob");
            player.Hand.Push(card);

            Assert.AreEqual(card.ToString(), player.TurnCard().ToString());
            Assert.AreEqual(0, player.Hand.Count);
        }

        [Test]
        public void HaveReactionTime_Between0And2000()
        {
            var player = new Player("Bob");

            Assert.LessOrEqual(0, player.ReactionTime);
            Assert.Greater(2000, player.ReactionTime);
        }
    }
}