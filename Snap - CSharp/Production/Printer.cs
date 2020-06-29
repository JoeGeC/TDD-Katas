using System;

namespace Snap_Joe_Khoovi
{
    public class Printer : IPrintable
    {
        public void Print(string message)
        {
            Console.WriteLine(message);
        }
    }
}