using System;

namespace Island
{
    class IslandSolver
    {
        // Array of 0s and 1s to solve
        private int[,] ocean;
        // Array of whether the 1 has been visited before
        private bool[,] visited;

        public IslandSolver(int size)
        {
            ocean = randomArray(size);
            visited = new bool[size, size];
        }

        int[,] randomArray(int size)
        {
            // Initialize Random Generator
            Random rnd = new Random();
            int[,] array = new int[size, size];

            for (int i = 0; i < size; ++i)
            {
                for (int j = 0; j < size; ++j)
                {
                    // Randomly assign 0 or 1 50% chance.
                    if (rnd.Next(0, 3) == 1)
                    {
                        array[i, j] = 1;
                    }
                    else
                    {
                        array[i, j] = 0;
                    }
                }
            }

            return array;
        }

        public int[,] getOcean()
        {
            return ocean;
        }

        public int solve()
        {
            int count = 0;

            // Traverse the ocean until we find a 1
            for (int i = 0; i < ocean.GetLength(0); ++i)
            {
                for (int j = 0; j < ocean.GetLength(1); ++j)
                {
                    if (ocean[i,j] == 1 && !visited[i,j])
                    {
                        traverseIsland(i, j);
                        count++;
                    }
                }
            }

            return count;
        }

        void traverseIsland(int i, int j)
        {
            if (canVisit(i, j))
            {
                visited[i, j] = true;
                traverseIsland(i - 1, j - 1);
                traverseIsland(i - 1, j);
                traverseIsland(i - 1, j + 1);
                traverseIsland(i, j - 1);
                traverseIsland(i, j + 1);
                traverseIsland(i + 1, j + 1);
                traverseIsland(i + 1, j);
                traverseIsland(i + 1, j - 1);
            }
        }

        bool canVisit(int i, int j)
        {
            if (i >= ocean.GetLength(0) || i < 0)
            {
                return false;
            }
            if (j >= ocean.GetLength(1) || j < 0)
            {
                return false;
            }
            if (ocean[i,j] == 0)
            {
                return false;
            }
            if (visited[i,j])
            {
                return false;
            }
            return true;
        }
    }
}
