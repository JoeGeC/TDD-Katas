using System.Collections.Generic;
using System.Linq;

namespace Snap_Joe_Khoovi
{
    public class SnapGame
    {
        public Deck Deck { get; }
        private IPrintable Console { get; }
        private readonly List<Player> _players;
        private Card _previousCard;
        private Card _currentCard;

        public SnapGame(List<Player> players, Deck deck, IPrintable console)
        {
            _players = players;
            Deck = deck;
            Console = console;
        }

        public void Play()
        {
            Deck.Shuffle();
            Deal();
            while (StillHasCards())
                if (_players.Any(ProcessTurn)) return;
            Console.Print("Game is a draw!");
        }

        public void Deal()
        {
            var deckSize = Deck.Cards.Count;
            for (var i = 0; i < deckSize / 2; i++)
                foreach (var player in _players) player.Hand.Push(Deck.DealACard());
        }

        private bool StillHasCards()
        {
            return _players[1].Hand.Count > 0;
        }

        private bool ProcessTurn(Player player)
        {
            WaitForReactionTime(player);
            _previousCard = _currentCard;
            _currentCard = player.TurnCard();
            Console.Print($"{player.Name} turns card '{_currentCard}'\n");
            return CheckForWinner();
        }

        private static void WaitForReactionTime(Player player)
        {
            System.Threading.Thread.Sleep(player.ReactionTime);
        }

        private bool CheckForWinner()
        {
            var fastestPlayer = FastestPlayer();
            WaitForReactionTime(fastestPlayer);
            if (_previousCard != null && CardMatches(_previousCard, _currentCard))
                return PrintWinner(fastestPlayer);
            return false;
        }

        private static bool CardMatches(Card previousCard, Card currentCard)
        {
            return previousCard.Rank == currentCard.Rank;
        }

        private bool PrintWinner(Player winner)
        {
            Console.Print($"SNAP! {winner.Name} is the winner!!");
            return true;
        }

        private Player FastestPlayer()
        {
            return _players[0].ReactionTime <= _players[1].ReactionTime ? _players[0] : _players[1];
        }
    }
}