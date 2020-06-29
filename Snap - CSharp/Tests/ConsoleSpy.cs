using System;

namespace Snap_Joe_Khoovi
{
    public class ConsoleSpy : IPrintable
    {
        public string Result { get; private set; }

        public void Print(string message)
        {
            Result += message;
        }
    }
}