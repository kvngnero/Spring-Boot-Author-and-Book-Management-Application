import React from 'react';
import { BookOpen } from 'lucide-react';

function App() {
  return (
    <div className="min-h-screen bg-gray-50">
      {/* Header */}
      <header className="bg-white shadow-sm">
        <div className="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8 py-4">
          <div className="flex items-center justify-between">
            <div className="flex items-center">
              <BookOpen className="h-8 w-8 text-indigo-600" />
              <h1 className="ml-3 text-2xl font-bold text-gray-900">Book Management System</h1>
            </div>
            <nav className="flex space-x-4">
              <a href="/books" className="text-gray-600 hover:text-gray-900 px-3 py-2 rounded-md text-sm font-medium">
                Books
              </a>
              <a href="/authors" className="text-gray-600 hover:text-gray-900 px-3 py-2 rounded-md text-sm font-medium">
                Authors
              </a>
            </nav>
          </div>
        </div>
      </header>

      {/* Main Content */}
      <main className="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8 py-8">
        <div className="bg-white shadow-sm rounded-lg p-6">
          <div className="grid grid-cols-1 md:grid-cols-2 gap-6">
            {/* Books Section */}
            <div>
              <h2 className="text-xl font-semibold text-gray-900 mb-4">Books</h2>
              <div className="space-y-4">
                <a href="/books/new" className="block p-4 border border-gray-200 rounded-lg hover:border-indigo-500 transition-colors">
                  <div className="flex items-center justify-between">
                    <span className="text-gray-900">Add New Book</span>
                    <span className="text-indigo-600">→</span>
                  </div>
                </a>
                <a href="/books" className="block p-4 border border-gray-200 rounded-lg hover:border-indigo-500 transition-colors">
                  <div className="flex items-center justify-between">
                    <span className="text-gray-900">View All Books</span>
                    <span className="text-indigo-600">→</span>
                  </div>
                </a>
              </div>
            </div>

            {/* Authors Section */}
            <div>
              <h2 className="text-xl font-semibold text-gray-900 mb-4">Authors</h2>
              <div className="space-y-4">
                <a href="/authors/new" className="block p-4 border border-gray-200 rounded-lg hover:border-indigo-500 transition-colors">
                  <div className="flex items-center justify-between">
                    <span className="text-gray-900">Add New Author</span>
                    <span className="text-indigo-600">→</span>
                  </div>
                </a>
                <a href="/authors" className="block p-4 border border-gray-200 rounded-lg hover:border-indigo-500 transition-colors">
                  <div className="flex items-center justify-between">
                    <span className="text-gray-900">View All Authors</span>
                    <span className="text-indigo-600">→</span>
                  </div>
                </a>
              </div>
            </div>
          </div>

          {/* Quick Stats */}
          <div className="mt-8 grid grid-cols-1 md:grid-cols-2 gap-4">
            <div className="bg-gray-50 p-4 rounded-lg">
              <h3 className="text-lg font-medium text-gray-900">Total Books</h3>
              <p className="mt-2 text-3xl font-bold text-indigo-600">0</p>
            </div>
            <div className="bg-gray-50 p-4 rounded-lg">
              <h3 className="text-lg font-medium text-gray-900">Total Authors</h3>
              <p className="mt-2 text-3xl font-bold text-indigo-600">0</p>
            </div>
          </div>
        </div>
      </main>

      {/* Footer */}
      <footer className="bg-white border-t border-gray-200 mt-8">
        <div className="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8 py-6">
          <p className="text-center text-gray-500 text-sm">
            © 2025 Book Management System. All rights reserved.
          </p>
        </div>
      </footer>
    </div>
  );
}

export default App;