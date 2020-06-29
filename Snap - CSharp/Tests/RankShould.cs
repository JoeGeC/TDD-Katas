using NUnit.Framework;

namespace Snap_Joe_Khoovi
{
    public class RankShould
    {
        [Test]
        public void DisplayDescription()
        {
            Assert.AreEqual("A", Rank.Ace.GetDescription());
        }
    }
}