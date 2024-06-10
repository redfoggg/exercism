defmodule BinarySearch do
  @doc """
    Searches for a key in the tuple using the binary search algorithm.
    It returns :not_found if the key is not in the tuple.
    Otherwise returns {:ok, index}.

    ## Examples

      iex> BinarySearch.search({}, 2)
      :not_found

      iex> BinarySearch.search({1, 3, 5}, 2)
      :not_found

      iex> BinarySearch.search({1, 3, 5}, 5)
      {:ok, 2}

  """

  @spec search(tuple, integer) :: {:ok, integer} | :not_found
  def search(numbers, key) do
    index = trunc((tuple_size(numbers) - 1) / 2)
    search(numbers, key, index, [])
  end

  def search(numbers, key, index, mem) do
    pointer = elem(numbers, index)
    new_mem = [pointer | mem]
    IO.puts pointer
    cond do
      pointer == key -> {:ok, index}
      pointer in mem and key != pointer -> :not_found
      true -> search(numbers, key, new_index(pointer, key, index, tuple_size(numbers), new_mem), new_mem)
    end
  end

  defp new_index(pointer, key, index, size, mem) do
    cond do
      key > pointer and hd(mem) < pointer -> trunc((index + size)/2)
      key > pointer -> trunc((index + size)/2)
      key < pointer -> trunc(index / 2)
    end
  end
end
