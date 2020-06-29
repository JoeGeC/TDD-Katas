using System;
using System.ComponentModel;
using System.Globalization;
using System.Linq;

namespace Snap_Joe_Khoovi
{
    public class Card
    {
        public Rank Rank { get; }
        private Suit Suit { get; }

        public Card(Rank rank, Suit suit)
        {
            Rank = rank;
            Suit = suit;
        }

        public override string ToString()
        {
            return $"{Rank.GetDescription()}{Suit.GetDescription()}";
        }
    }
}

public enum Rank
{
    [Description("A")] Ace,
    [Description("2")] Two,
    [Description("3")] Three,
    [Description("4")] Four,
    [Description("5")] Five,
    [Description("6")] Six,
    [Description("7")] Seven,
    [Description("8")] Eight,
    [Description("9")] Nine,
    [Description("10")] Ten,
    [Description("J")] Jack,
    [Description("Q")] Queen,
    [Description("K")] King
}

public enum Suit
{
    [Description("S")] Spade,
    [Description("C")] Club,
    [Description("D")] Diamond,
    [Description("H")] Heart
}

public static class EnumDescription
{
    public static string GetDescription<T>(this T e) where T : IConvertible
    {
        if (!(e is Enum)) return null; // could also return string.Empty
        var type = e.GetType();
        var values = Enum.GetValues(type);

        return (from int val in values
                where val == e.ToInt32(CultureInfo.InvariantCulture)
                select type.GetMember(type.GetEnumName(val) ?? throw new InvalidOperationException())
                into memInfo
                select memInfo[0]
                    .GetCustomAttributes(typeof(DescriptionAttribute), false)
                    .FirstOrDefault()).OfType<DescriptionAttribute>()
            .Select(descriptionAttribute => descriptionAttribute.Description)
            .FirstOrDefault();
    }
}