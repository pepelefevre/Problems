using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace IndexesMaxDifference
{

    // Given an array,find the maximum j – i such that arr[j] > arr[i]
    class Program
    {
        int[] myArray;

        Program (int size)
        {
            myArray = new int[size];
        }

        Program (int[] array)
        {
            myArray = array;
        }

        string getRandArray()
        {
            string str = "[";
            Random rnd = new Random();
            for (int i = 0; i < myArray.Length; ++i)
            {
                myArray[i] = rnd.Next(0, 100);
                str += " " + myArray[i];
            }

            str += " ]";
            return str;
        }

        string solve(int[] array)
        {
            int i = 0;
            int j = array.Length - 1;
            for (int c = j - i; j > i; --c)
            {
                for (i = 0, j = i + c; j < array.Length; ++i, j = i + c)
                {
                    if (array[j] > array[i])
                    {
                        string solution = "" + (j - i) + "( j = " + j + " i = " + i + " )";
                        return solution;
                    }
                }
            }

            return "No solution";

        }

        static void Main(string[] args)
        {
            Console.WriteLine("Enter size of array (0 for enter you own): ");
            string sizeStr = Console.ReadLine();
            int size = 0;

            if (int.TryParse(sizeStr, out size))
            {
                Program program;
                if (size != 0)
                {
                    program = new Program(size);
                    Console.WriteLine(program.getRandArray());

                }
                else
                {
                    program = new Program(new int[] { 34, 8, 10, 3, 2, 80, 30, 33, 1 });
                }
                Console.WriteLine(program.solve(program.myArray));
                Console.ReadLine();
            }
            else
            {
                Console.WriteLine("Not an integer, asshole");
            }
        }
    }


}
