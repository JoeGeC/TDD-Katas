using NUnit.Framework;

namespace Snap_Joe_Khoovi
{
    public class CardShould
    {
        [Test]
        public void PrintValueOfCard()
        {
            Assert.AreEqual("AS", new Card(Rank.Ace, Suit.Spade).ToString());
        }
    }
}