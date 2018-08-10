#include <iostream>
#include <cstdlib>

using namespace std;

typedef struct location
{
	int x = 0;
	int y = 0;
};

location human;
location key;
location door;
bool haveKey = 0;
bool escape = 0;
char map[4][4];


void MakeMap()
{
	for (int i = 0; i < 4; ++i)
	{
		for (int j = 0; j < 4; ++j)
		{
			map[i][j] = '_';
		}
	}
}


void MakeHuman()
{
	human.x = 0;
	human.y = 0;
	
	map[human.y][human.x] = 'P';
}


void MakeKey()
{
	key.x = rand() % 3 + 1;
	key.y = rand() % 3 + 1;
	
	map[key.y][key.x] = 'K';
}


void MakeDoor()
{
	do
	{
		door.y = rand() % 3 + 1;
		door.x = rand() % 3 + 1;
	}
	while ((door.y == key.y) && (door.x == key.x));
	
	map[door.y][door.x] = 'E';
}


void ShowMap()
{
	for (int i = 0; i < 4; ++i)
	{
		for (int j = 0; j < 4; ++j)
		{
			cout << map[i][j] << " ";
		}
		cout << endl;
	}
}


void MoveUp()
{
	if (human.y == 0)
		return;
		
	if ( map[human.y - 1][human.x] == 'E' && haveKey == 0 )
	{
		cout << "You can't exit. Please acquire the key(s) firts." << endl;
		return;
	}
	else if ( map[human.y - 1][human.x] == 'E' && haveKey == 1 )
	{
		cout << "Congrats, you have just escaped the dungeon!" << endl;
		escape = 1;
		
		int temp = human.y;
		--human.y;
		
		map[human.y][human.x] = 'P';
		map[temp][human.x] = '_';
		
		return;
	}
		
	int temp = human.y;
	--human.y;
	
	if ( map[human.y][human.x] == 'K' )
	{
		cout << "You've just picked up a key!!!" << endl;
		haveKey++;
	}
	
	map[human.y][human.x] = 'P';
	map[temp][human.x] = '_';
}


void MoveLeft()
{
	if (human.x == 0)
		return;
		
	if ( map[human.y][human.x - 1] == 'E' && haveKey == 0 )
	{
		cout << "You can't exit. Please acquire the key(s) firts." << endl;
		return;
	}
	else if ( map[human.y][human.x - 1] == 'E' && haveKey == 1 )
	{
		cout << "Congrats, you have just escaped the dungeon!" << endl;
		escape = 1;
		
		int temp = human.x;
		--human.x;
		
		map[human.y][human.x] = 'P';
		map[human.y][temp] = '_';
		
		return;
	}
		
	int temp = human.x;
	--human.x;
	
	if ( map[human.y][human.x] == 'K' )
	{
		cout << "You've just picked up a key!!!" << endl;
		haveKey++;
	}
	
	map[human.y][human.x] = 'P';
	map[human.y][temp] = '_';
}


void MoveDown()
{
	if (human.y == 3)
		return;
		
	if ( map[human.y + 1][human.x] == 'E' && haveKey == 0 )
	{
		cout << "You can't exit. Please acquire the key(s) firts." << endl;
		return;
	}
	else if ( map[human.y + 1][human.x] == 'E' && haveKey == 1 )
	{
		cout << "Congrats, you have just escaped the dungeon!" << endl;
		escape = 1;
		
		int temp = human.y;
		++human.y;
		
		map[human.y][human.x] = 'P';
		map[temp][human.x] = '_';
		
		return;
	}
		
	int temp = human.y;
	++human.y;
	
	if ( map[human.y][human.x] == 'K' )
	{
		cout << "You've just picked up a key!!!" << endl;
		haveKey++;
	}
	
	map[human.y][human.x] = 'P';
	map[temp][human.x] = '_';
}


void MoveRight()
{
	if (human.x == 3)
		return;
		
	if ( map[human.y][human.x + 1] == 'E' && haveKey == 0 )
	{
		cout << "You can't exit. Please acquire the key(s) firts." << endl;
		return;
	}
	else if ( map[human.y][human.x + 1] == 'E' && haveKey == 1 )
	{
		cout << "Congrats, you have just escaped the dungeon!" << endl;
		escape = 1;
		
		int temp = human.x;
		++human.x;
		
		map[human.y][human.x] = 'P';
		map[human.y][temp] = '_';
		
		return;
	}
		
	int temp = human.x;
	++human.x;
	
	if ( map[human.y][human.x] == 'K' )
	{
		cout << "You've just picked up a key!!!" << endl;
		haveKey++;
	}
	
	map[human.y][human.x] = 'P';
	map[human.y][temp] = '_';
}


void HumanMove()
{
	char direct;
	
	cout << "Your move ? ";
	cin >> direct;
	
	switch (direct)
	{
		case 'w':
		{
			MoveUp();
			break;
		}
		
		case 'a':
		{
			MoveLeft();
			break;
		}
		
		case 's':
		{
			MoveDown();
			break;
		}
		
		case 'd':
		{
			MoveRight();
			break;
		}
	}
	
	cout << endl;
}


void NewGame()
{
	haveKey = 0;
	escape = 0;
}


void Play()
{
	char again = 'n';
	
	do
	{
		MakeMap();
		MakeHuman();
		MakeKey();
		MakeDoor();
		
		do
		{
			NewGame();
			ShowMap();
			HumanMove();
		}
		while (escape == 0);
		
		cout << endl;
		cout << "Do you want to play again ? (Y/N) ";
		cin >> again;
	}
	while (again == 'y');
}


int main()
{
	Play();
	
	return 0;
}
