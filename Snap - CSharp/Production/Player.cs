using System;
using System.Collections.Generic;

namespace Snap_Joe_Khoovi
{
    public class Player
    {
        public string Name { get; }
        public Stack<Card> Hand { get; }
        public virtual int ReactionTime
        {
            get => new Random().Next(0, 2000);
            set { }
        }

        public Player(string name)
        {
            Hand = new Stack<Card>();
            Name = name;
        }

        public Card TurnCard()
        {
            return Hand.Pop();
        }
    }

    public class StubPlayer : Player
    {
        public StubPlayer(string name) : base(name)
        {
        }

        public override int ReactionTime { get; set; }
    }
}