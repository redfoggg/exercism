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
  def search(numbers, key) when numbers != {} do
    right_pointer = tuple_size(numbers) - 1
    left_pointer = 0
    index = trunc(middle_index(left_pointer, right_pointer))
    search(numbers, left_pointer, right_pointer, index, key)
  end
  
  def search(numbers, _key) when numbers == {}, do: :not_found

  def search(numbers, left_pointer, right_pointer, index, key) do
    point = elem(numbers, index)

    cond do
      point == key -> {:ok, index}
      left_pointer == index or right_pointer == index -> :not_found
      point < key -> search(numbers, index, right_pointer, round(middle_index(index, right_pointer)), key)
      point > key -> search(numbers, left_pointer, index, trunc(middle_index(left_pointer, index)), key)
    end
  end

  defp middle_index(left_pointer, right_pointer) do
    (right_pointer + left_pointer) / 2
  end
end
